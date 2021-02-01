package com.baidu.tieba.newfaceshop.nativemotionmanager.view;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener, com.baidu.tieba.faceshop.emotioncenter.a.c {
    private Animation iYH = null;
    private View iYL;
    private ImageView iYO;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iYU;
    private ImageView iYW;
    private TextView iYX;
    private View lDt;
    private View lDu;
    private TextView lDv;
    private int lDw;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.lDw = i;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.iYL = this.mRootView.findViewById(R.id.emotion_manager_add_layout);
        this.lDt = this.mRootView.findViewById(R.id.emotion_manager_create);
        this.lDt.setOnClickListener(this);
        this.iYL.setVisibility(0);
        this.lDu = this.mRootView.findViewById(R.id.emotion_manager_upload_status);
        this.lDu.setClickable(false);
        this.lDu.setOnClickListener(this);
        this.lDu.setVisibility(8);
        this.iYW = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iYO = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.lDv = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iYX = (TextView) this.mRootView.findViewById(R.id.add_emotion_manager_upload_status);
    }

    public void cAb() {
        if (this.iYU != null) {
            this.iYU.dismiss();
        }
        startAnimation();
        this.lDu.setVisibility(0);
        this.iYL.setVisibility(8);
        ap.setBackgroundColor(this.lDu, R.color.CAM_X0201);
        ap.setImageResource(this.iYW, R.drawable.emotion_uploading_bar_refresh);
        ap.setViewTextColor(this.iYX, R.color.CAM_X0302);
        this.iYX.setText(R.string.emotion_uploading);
        this.lDu.setClickable(false);
    }

    public void cAc() {
        FaceGroupDraft diE = com.baidu.tieba.newfaceshop.facemake.e.diD().diE();
        if (diE != null && TextUtils.isEmpty(diE.getFailMsg())) {
            l.showToast(this.mPageContext.getPageActivity(), diE.getFailMsg());
        }
        OV(null);
    }

    public void OV(String str) {
        if (this.iYU != null) {
            this.iYU.dismiss();
        }
        endAnimation();
        this.lDu.setVisibility(0);
        this.iYL.setVisibility(8);
        ap.setBackgroundColor(this.lDu, R.color.CAM_X0201);
        ap.setImageResource(this.iYW, R.drawable.emotion_update_fail);
        ap.setViewTextColor(this.iYX, R.color.common_color_10037);
        if (!TextUtils.isEmpty(str)) {
            this.iYX.setText(str);
        } else {
            this.iYX.setText(R.string.emotion_center_upload_failed);
        }
        this.lDu.setClickable(true);
    }

    public void cAa() {
        if (this.iYU != null) {
            this.iYU.dismiss();
        }
        endAnimation();
        this.lDu.setVisibility(8);
        this.iYL.setVisibility(0);
    }

    public void endAnimation() {
        if (this.iYW != null) {
            this.iYW.clearAnimation();
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iYH == null) {
            this.iYH = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iYH.setInterpolator(new LinearInterpolator());
            this.iYH.setFillAfter(true);
        }
        return this.iYH;
    }

    public void startAnimation() {
        if (this.iYW != null) {
            this.iYW.startAnimation(getClickRotateAnimation());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lDt != null && view.getId() == this.lDt.getId() && this.lDt.isShown()) {
            if (this.lDw == 1) {
                if (this.iYU == null) {
                    this.iYU = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.lDw);
                    this.iYU.a(this);
                }
                this.iYU.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.iYU.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            } else {
                czR();
            }
        }
        if (this.lDu != null && view.getId() == this.lDu.getId() && this.lDu.isShown()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.lDw == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.iYL != null) {
            ap.setBackgroundColor(this.iYL, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iYX != null) {
            ap.setViewTextColor(this.iYX, R.color.CAM_X0302, i);
        }
        if (this.iYO != null) {
            ap.setImageResource(this.iYO, R.drawable.emotion_bar_add_icon);
        }
        if (this.lDv != null) {
            ap.setViewTextColor(this.lDv, R.color.CAM_X0302, i);
        }
        if (this.lDu != null) {
            ap.setBackgroundColor(this.lDu, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iYW != null) {
            ap.setImageResource(this.iYW, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void onDestroy() {
        if (this.iYU != null && this.iYU.isShowing()) {
            this.iYU.dismiss();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void czQ() {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dim = com.baidu.tieba.newfaceshop.c.dil().dim();
                final int size = dim == null ? 0 : dim.size();
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (size >= 30) {
                            l.showToast(a.this.mPageContext.getPageActivity(), String.format(a.this.mPageContext.getString(R.string.emotion_create_tip), 30));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(a.this.mPageContext.getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
                        }
                    }
                });
            }
        });
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void czR() {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dim = com.baidu.tieba.newfaceshop.c.dil().dim();
                final int size = dim == null ? 0 : dim.size();
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (size >= 30) {
                            l.showToast(a.this.mPageContext.getPageActivity(), String.format(a.this.mPageContext.getString(R.string.emotion_create_tip), 30));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(a.this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
                        }
                    }
                });
            }
        });
    }
}
