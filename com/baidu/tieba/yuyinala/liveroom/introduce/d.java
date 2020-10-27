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
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private w aEc;
    private TextView bGd;
    public CustomMessageListener bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.mDialog.dismiss();
                }
                MessageManager.getInstance().unRegisterListener(d.this.bcQ);
            } catch (Exception e) {
            }
        }
    };
    private ImageView eqR;
    private TextView fmY;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleTextView;
    private View mView;
    private TextView nPH;
    private i nPI;
    private h nPy;

    public d(Context context) {
        this.mContext = context;
        initDialog();
        this.nPI = new i(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitleTextView.setText(str);
        } else if (this.aEc != null && this.aEc.aIS != null) {
            this.mTitleTextView.setText(this.aEc.aIS.room_name);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.fmY.setText(str2);
        }
        if (z) {
            this.bGd.setVisibility(8);
            this.nPH.setVisibility(0);
            this.eqR.setVisibility(0);
            this.mView.setVisibility(0);
            return;
        }
        this.bGd.setVisibility(0);
        this.nPH.setVisibility(8);
        this.eqR.setVisibility(8);
        this.mView.setVisibility(8);
    }

    public void P(w wVar) {
        this.aEc = wVar;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.mRootView.setVisibility(8);
            if (this.aEc != null && this.aEc.aIS != null) {
                this.nPI.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void a(AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage) {
                        boolean z = true;
                        d.this.nPy = alaGetRoomPlayIntroduceHttpResponseMessage.dVp();
                        boolean iK = n.dWB().iK(n.dWB().UN());
                        if (d.this.aEc == null || d.this.aEc.aIA == null || (d.this.aEc.aIA.userType != 1 && (d.this.aEc.aIA.userType != 2 || !iK))) {
                            z = false;
                        }
                        d.this.E(d.this.nPy.nPP, d.this.nPy.nPQ, z);
                        d.this.mRootView.setVisibility(0);
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void onFail(int i, String str) {
                        BdUtilHelper.showToast(d.this.mContext, str);
                        d.this.dismiss();
                    }
                });
                this.nPI.request(this.aEc.aIS.aRy);
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
        if (view == this.mRootView || view == this.eqR || view == this.bGd) {
            dismiss();
        }
        if (view == this.nPH && this.nPy != null) {
            new c(this.mContext).b(this.aEc, this.mTitleTextView.getText().toString().trim(), this.nPy.nPQ);
            dismiss();
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
        OE();
        initView();
    }

    private void OE() {
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
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.yuyin_room_introduce_dialog_common_alert, (ViewGroup) null);
        this.mDialog.setContentView(this.mRootView);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.bGd = (TextView) this.mRootView.findViewById(a.g.tv_confirm);
        this.nPH = (TextView) this.mRootView.findViewById(a.g.tv_modify);
        this.eqR = (ImageView) this.mRootView.findViewById(a.g.iv_close);
        this.fmY = (TextView) this.mRootView.findViewById(a.g.tv_content);
        this.mView = this.mRootView.findViewById(a.g.view_line);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.g.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bGd.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.bGd.setOnClickListener(this);
        this.eqR.setOnClickListener(this);
        this.nPH.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.bcQ);
    }
}
