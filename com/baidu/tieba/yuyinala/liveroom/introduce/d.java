package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private w aES;
    private TextView bLI;
    public CustomMessageListener bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.mDialog.dismiss();
                }
                MessageManager.getInstance().unRegisterListener(d.this.bek);
            } catch (Exception e) {
            }
        }
    };
    private ImageView ewK;
    private TextView fsR;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleTextView;
    private View mView;
    private h nWH;
    private TextView nWQ;
    private i nWR;

    public d(Context context) {
        this.mContext = context;
        initDialog();
        this.nWR = new i(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitleTextView.setText(str);
        } else if (this.aES != null && this.aES.aJK != null) {
            this.mTitleTextView.setText(this.aES.aJK.room_name);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.fsR.setText(str2);
        }
        if (z) {
            this.bLI.setVisibility(8);
            this.nWQ.setVisibility(0);
            this.ewK.setVisibility(0);
            this.mView.setVisibility(0);
            return;
        }
        this.bLI.setVisibility(0);
        this.nWQ.setVisibility(8);
        this.ewK.setVisibility(8);
        this.mView.setVisibility(8);
    }

    public void X(w wVar) {
        this.aES = wVar;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.mRootView.setVisibility(8);
            if (this.aES != null && this.aES.aJK != null) {
                this.nWR.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void a(AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage) {
                        boolean z = true;
                        d.this.nWH = alaGetRoomPlayIntroduceHttpResponseMessage.dYe();
                        boolean iX = o.dZA().iX(o.dZA().Xm());
                        if (d.this.aES == null || d.this.aES.aJr == null || (d.this.aES.aJr.userType != 1 && (d.this.aES.aJr.userType != 2 || !iX))) {
                            z = false;
                        }
                        d.this.F(d.this.nWH.nWY, d.this.nWH.nWZ, z);
                        d.this.mRootView.setVisibility(0);
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void onFail(int i, String str) {
                        BdUtilHelper.showToast(d.this.mContext, str);
                        d.this.dismiss();
                    }
                });
                this.nWR.request(this.aES.aJK.aSP);
            }
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView || view == this.ewK || view == this.bLI) {
            dismiss();
        }
        if (view == this.nWQ && this.nWH != null) {
            new c(this.mContext).b(this.aES, this.mTitleTextView.getText().toString().trim(), this.nWH.nWZ);
            dismiss();
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
        Pe();
        initView();
    }

    private void Pe() {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) this.mDialog.getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = ScreenHelper.getRealScreenHeight(this.mContext);
                    attributes.height = -1;
                } else {
                    attributes.width = -1;
                    attributes.height = ScreenHelper.getRealScreenHeight(this.mContext) - UtilHelper.getStatusBarHeight();
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.yuyin_room_introduce_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.bLI = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.nWQ = (TextView) this.mRootView.findViewById(a.f.tv_modify);
        this.ewK = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.fsR = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.mView = this.mRootView.findViewById(a.f.view_line);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bLI.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.bLI.setOnClickListener(this);
        this.ewK.setOnClickListener(this);
        this.nWQ.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.bek);
    }
}
