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
    private w aFN;
    private TextView bPe;
    public CustomMessageListener bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.mDialog.dismiss();
                }
                MessageManager.getInstance().unRegisterListener(d.this.bgy);
            } catch (Exception e) {
            }
        }
    };
    private ImageView eCd;
    private TextView fzP;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleTextView;
    private View mView;
    private h onk;
    private TextView ont;
    private i onu;

    public d(Context context) {
        this.mContext = context;
        initDialog();
        this.onu = new i(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitleTextView.setText(str);
        } else if (this.aFN != null && this.aFN.aKL != null) {
            this.mTitleTextView.setText(this.aFN.aKL.room_name);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.fzP.setText(str2);
        }
        if (z) {
            this.bPe.setVisibility(8);
            this.ont.setVisibility(0);
            this.eCd.setVisibility(0);
            this.mView.setVisibility(0);
            return;
        }
        this.bPe.setVisibility(0);
        this.ont.setVisibility(8);
        this.eCd.setVisibility(8);
        this.mView.setVisibility(8);
    }

    public void ac(w wVar) {
        this.aFN = wVar;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.mRootView.setVisibility(8);
            if (this.aFN != null && this.aFN.aKL != null) {
                this.onu.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void a(AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage) {
                        boolean z = true;
                        d.this.onk = alaGetRoomPlayIntroduceHttpResponseMessage.edH();
                        boolean jv = o.efd().jv(o.efd().Zc());
                        if (d.this.aFN == null || d.this.aFN.aKr == null || (d.this.aFN.aKr.userType != 1 && (d.this.aFN.aKr.userType != 2 || !jv))) {
                            z = false;
                        }
                        d.this.H(d.this.onk.onB, d.this.onk.onC, z);
                        d.this.mRootView.setVisibility(0);
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void onFail(int i, String str) {
                        BdUtilHelper.showToast(d.this.mContext, str);
                        d.this.dismiss();
                    }
                });
                this.onu.request(this.aFN.aKL.aUg);
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
        if (view == this.mRootView || view == this.eCd || view == this.bPe) {
            dismiss();
        }
        if (view == this.ont && this.onk != null) {
            new c(this.mContext).b(this.aFN, this.mTitleTextView.getText().toString().trim(), this.onk.onC);
            dismiss();
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
        Ki();
        initView();
    }

    private void Ki() {
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
        this.bPe = (TextView) this.mRootView.findViewById(a.f.tv_confirm);
        this.ont = (TextView) this.mRootView.findViewById(a.f.tv_modify);
        this.eCd = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.fzP = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.mView = this.mRootView.findViewById(a.f.view_line);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.bPe.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.bPe.setOnClickListener(this);
        this.eCd.setOnClickListener(this);
        this.ont.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.bgy);
    }
}
