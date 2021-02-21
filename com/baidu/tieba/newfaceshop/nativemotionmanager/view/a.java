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
    private Animation iYV = null;
    private View iYZ;
    private ImageView iZc;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iZi;
    private ImageView iZk;
    private TextView iZl;
    private View lDH;
    private View lDI;
    private TextView lDJ;
    private int lDK;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.lDK = i;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.iYZ = this.mRootView.findViewById(R.id.emotion_manager_add_layout);
        this.lDH = this.mRootView.findViewById(R.id.emotion_manager_create);
        this.lDH.setOnClickListener(this);
        this.iYZ.setVisibility(0);
        this.lDI = this.mRootView.findViewById(R.id.emotion_manager_upload_status);
        this.lDI.setClickable(false);
        this.lDI.setOnClickListener(this);
        this.lDI.setVisibility(8);
        this.iZk = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iZc = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.lDJ = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iZl = (TextView) this.mRootView.findViewById(R.id.add_emotion_manager_upload_status);
    }

    public void cAi() {
        if (this.iZi != null) {
            this.iZi.dismiss();
        }
        startAnimation();
        this.lDI.setVisibility(0);
        this.iYZ.setVisibility(8);
        ap.setBackgroundColor(this.lDI, R.color.CAM_X0201);
        ap.setImageResource(this.iZk, R.drawable.emotion_uploading_bar_refresh);
        ap.setViewTextColor(this.iZl, R.color.CAM_X0302);
        this.iZl.setText(R.string.emotion_uploading);
        this.lDI.setClickable(false);
    }

    public void cAj() {
        FaceGroupDraft diL = com.baidu.tieba.newfaceshop.facemake.e.diK().diL();
        if (diL != null && TextUtils.isEmpty(diL.getFailMsg())) {
            l.showToast(this.mPageContext.getPageActivity(), diL.getFailMsg());
        }
        OW(null);
    }

    public void OW(String str) {
        if (this.iZi != null) {
            this.iZi.dismiss();
        }
        endAnimation();
        this.lDI.setVisibility(0);
        this.iYZ.setVisibility(8);
        ap.setBackgroundColor(this.lDI, R.color.CAM_X0201);
        ap.setImageResource(this.iZk, R.drawable.emotion_update_fail);
        ap.setViewTextColor(this.iZl, R.color.common_color_10037);
        if (!TextUtils.isEmpty(str)) {
            this.iZl.setText(str);
        } else {
            this.iZl.setText(R.string.emotion_center_upload_failed);
        }
        this.lDI.setClickable(true);
    }

    public void cAh() {
        if (this.iZi != null) {
            this.iZi.dismiss();
        }
        endAnimation();
        this.lDI.setVisibility(8);
        this.iYZ.setVisibility(0);
    }

    public void endAnimation() {
        if (this.iZk != null) {
            this.iZk.clearAnimation();
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iYV == null) {
            this.iYV = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iYV.setInterpolator(new LinearInterpolator());
            this.iYV.setFillAfter(true);
        }
        return this.iYV;
    }

    public void startAnimation() {
        if (this.iZk != null) {
            this.iZk.startAnimation(getClickRotateAnimation());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lDH != null && view.getId() == this.lDH.getId() && this.lDH.isShown()) {
            if (this.lDK == 1) {
                if (this.iZi == null) {
                    this.iZi = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.lDK);
                    this.iZi.a(this);
                }
                this.iZi.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.iZi.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            } else {
                czY();
            }
        }
        if (this.lDI != null && view.getId() == this.lDI.getId() && this.lDI.isShown()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.lDK == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.iYZ != null) {
            ap.setBackgroundColor(this.iYZ, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iZl != null) {
            ap.setViewTextColor(this.iZl, R.color.CAM_X0302, i);
        }
        if (this.iZc != null) {
            ap.setImageResource(this.iZc, R.drawable.emotion_bar_add_icon);
        }
        if (this.lDJ != null) {
            ap.setViewTextColor(this.lDJ, R.color.CAM_X0302, i);
        }
        if (this.lDI != null) {
            ap.setBackgroundColor(this.lDI, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iZk != null) {
            ap.setImageResource(this.iZk, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void onDestroy() {
        if (this.iZi != null && this.iZi.isShowing()) {
            this.iZi.dismiss();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void czX() {
        com.baidu.tieba.newfaceshop.a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dit = com.baidu.tieba.newfaceshop.c.dis().dit();
                final int size = dit == null ? 0 : dit.size();
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
    public void czY() {
        com.baidu.tieba.newfaceshop.a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dit = com.baidu.tieba.newfaceshop.c.dis().dit();
                final int size = dit == null ? 0 : dit.size();
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
