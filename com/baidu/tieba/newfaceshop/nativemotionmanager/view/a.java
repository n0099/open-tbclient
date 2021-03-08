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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, com.baidu.tieba.faceshop.emotioncenter.a.c {
    private Animation jaE = null;
    private View jaI;
    private ImageView jaL;
    private com.baidu.tieba.faceshop.emotioncenter.a.a jaR;
    private ImageView jaT;
    private TextView jaU;
    private View lFJ;
    private View lFK;
    private TextView lFL;
    private int lFM;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.lFM = i;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.jaI = this.mRootView.findViewById(R.id.emotion_manager_add_layout);
        this.lFJ = this.mRootView.findViewById(R.id.emotion_manager_create);
        this.lFJ.setOnClickListener(this);
        this.jaI.setVisibility(0);
        this.lFK = this.mRootView.findViewById(R.id.emotion_manager_upload_status);
        this.lFK.setClickable(false);
        this.lFK.setOnClickListener(this);
        this.lFK.setVisibility(8);
        this.jaT = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.jaL = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.lFL = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.jaU = (TextView) this.mRootView.findViewById(R.id.add_emotion_manager_upload_status);
    }

    public void cAo() {
        if (this.jaR != null) {
            this.jaR.dismiss();
        }
        startAnimation();
        this.lFK.setVisibility(0);
        this.jaI.setVisibility(8);
        ap.setBackgroundColor(this.lFK, R.color.CAM_X0201);
        ap.setImageResource(this.jaT, R.drawable.emotion_uploading_bar_refresh);
        ap.setViewTextColor(this.jaU, R.color.CAM_X0302);
        this.jaU.setText(R.string.emotion_uploading);
        this.lFK.setClickable(false);
    }

    public void cAp() {
        FaceGroupDraft diU = com.baidu.tieba.newfaceshop.facemake.e.diT().diU();
        if (diU != null && TextUtils.isEmpty(diU.getFailMsg())) {
            l.showToast(this.mPageContext.getPageActivity(), diU.getFailMsg());
        }
        Pc(null);
    }

    public void Pc(String str) {
        if (this.jaR != null) {
            this.jaR.dismiss();
        }
        endAnimation();
        this.lFK.setVisibility(0);
        this.jaI.setVisibility(8);
        ap.setBackgroundColor(this.lFK, R.color.CAM_X0201);
        ap.setImageResource(this.jaT, R.drawable.emotion_update_fail);
        ap.setViewTextColor(this.jaU, R.color.common_color_10037);
        if (!TextUtils.isEmpty(str)) {
            this.jaU.setText(str);
        } else {
            this.jaU.setText(R.string.emotion_center_upload_failed);
        }
        this.lFK.setClickable(true);
    }

    public void cAn() {
        if (this.jaR != null) {
            this.jaR.dismiss();
        }
        endAnimation();
        this.lFK.setVisibility(8);
        this.jaI.setVisibility(0);
    }

    public void endAnimation() {
        if (this.jaT != null) {
            this.jaT.clearAnimation();
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.jaE == null) {
            this.jaE = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.jaE.setInterpolator(new LinearInterpolator());
            this.jaE.setFillAfter(true);
        }
        return this.jaE;
    }

    public void startAnimation() {
        if (this.jaT != null) {
            this.jaT.startAnimation(getClickRotateAnimation());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lFJ != null && view.getId() == this.lFJ.getId() && this.lFJ.isShown()) {
            if (this.lFM == 1) {
                if (this.jaR == null) {
                    this.jaR = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.lFM);
                    this.jaR.a(this);
                }
                this.jaR.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.jaR.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            } else {
                cAe();
            }
        }
        if (this.lFK != null && view.getId() == this.lFK.getId() && this.lFK.isShown()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.lFM == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.jaI != null) {
            ap.setBackgroundColor(this.jaI, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.jaU != null) {
            ap.setViewTextColor(this.jaU, R.color.CAM_X0302, i);
        }
        if (this.jaL != null) {
            ap.setImageResource(this.jaL, R.drawable.emotion_bar_add_icon);
        }
        if (this.lFL != null) {
            ap.setViewTextColor(this.lFL, R.color.CAM_X0302, i);
        }
        if (this.lFK != null) {
            ap.setBackgroundColor(this.lFK, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.jaT != null) {
            ap.setImageResource(this.jaT, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void onDestroy() {
        if (this.jaR != null && this.jaR.isShowing()) {
            this.jaR.dismiss();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cAd() {
        com.baidu.tieba.newfaceshop.a.diz().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> diC = com.baidu.tieba.newfaceshop.c.diB().diC();
                final int size = diC == null ? 0 : diC.size();
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
    public void cAe() {
        com.baidu.tieba.newfaceshop.a.diz().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> diC = com.baidu.tieba.newfaceshop.c.diB().diC();
                final int size = diC == null ? 0 : diC.size();
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
