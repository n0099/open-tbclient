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
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.yuyinala.liveroom.introduce.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private x aBr;
    public CustomMessageListener bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                if (d.this.mDialog != null && d.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.mDialog.dismiss();
                }
                MessageManager.getInstance().unRegisterListener(d.this.bdo);
            } catch (Exception e) {
            }
        }
    };
    private ImageView eGV;
    private TextView fEO;
    private Context mContext;
    private Dialog mDialog;
    private LinearLayout mPanelLayout;
    private View mRootView;
    private TextView mTitleTextView;
    private View mView;
    private h olU;
    private TextView omd;
    private i ome;

    public d(Context context) {
        this.mContext = context;
        initDialog();
        this.ome = new i(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitleTextView.setText(str);
        } else if (this.aBr != null && this.aBr.aGy != null) {
            this.mTitleTextView.setText(this.aBr.aGy.room_name);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.fEO.setText(str2);
        }
        if (z) {
            this.omd.setVisibility(0);
            this.eGV.setVisibility(0);
            this.mView.setVisibility(0);
            return;
        }
        this.omd.setVisibility(8);
        this.eGV.setVisibility(8);
        this.mView.setVisibility(8);
    }

    public void af(x xVar) {
        this.aBr = xVar;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.mRootView.setVisibility(8);
            if (this.aBr != null && this.aBr.aGy != null) {
                this.ome.a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.d.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void a(AlaGetRoomPlayIntroduceHttpResponseMessage alaGetRoomPlayIntroduceHttpResponseMessage) {
                        boolean z = true;
                        d.this.olU = alaGetRoomPlayIntroduceHttpResponseMessage.dZi();
                        boolean id = o.ebo().id(o.ebo().Wz());
                        if (d.this.aBr == null || d.this.aBr.aGd == null || (d.this.aBr.aGd.userType != 1 && (d.this.aBr.aGd.userType != 2 || !id))) {
                            z = false;
                        }
                        d.this.J(d.this.olU.oml, d.this.olU.omm, z);
                        d.this.mRootView.setVisibility(0);
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.introduce.i.a
                    public void onFail(int i, String str) {
                        BdUtilHelper.showToast(d.this.mContext, str);
                        d.this.dismiss();
                    }
                });
                this.ome.request(this.aBr.aGy.aQH);
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
        if (view == this.mRootView || view == this.eGV) {
            dismiss();
        }
        if (view == this.omd && this.olU != null) {
            new c(this.mContext).b(this.aBr, this.mTitleTextView.getText().toString().trim(), this.olU.omm);
            dismiss();
        }
    }

    private void initDialog() {
        this.mDialog = new Dialog(this.mContext);
        FP();
        initView();
    }

    private void FP() {
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
        this.omd = (TextView) this.mRootView.findViewById(a.f.tv_modify);
        this.eGV = (ImageView) this.mRootView.findViewById(a.f.iv_close);
        this.fEO = (TextView) this.mRootView.findViewById(a.f.tv_content);
        this.mView = this.mRootView.findViewById(a.f.view_line);
        this.mPanelLayout = (LinearLayout) this.mRootView.findViewById(a.f.layout_panel);
        ((RelativeLayout.LayoutParams) this.mPanelLayout.getLayoutParams()).setMargins(0, BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels / 3, 0, 0);
        this.mRootView.setOnClickListener(this);
        this.eGV.setOnClickListener(this);
        this.omd.setOnClickListener(this);
        MessageManager.getInstance().registerListener(this.bdo);
    }
}
