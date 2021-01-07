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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener, com.baidu.tieba.faceshop.emotioncenter.a.c {
    private Animation iXH = null;
    private View iXL;
    private ImageView iXO;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iXU;
    private ImageView iXW;
    private TextView iXX;
    private View lzV;
    private View lzW;
    private TextView lzX;
    private int lzY;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.lzY = i;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.iXL = this.mRootView.findViewById(R.id.emotion_manager_add_layout);
        this.lzV = this.mRootView.findViewById(R.id.emotion_manager_create);
        this.lzV.setOnClickListener(this);
        this.iXL.setVisibility(0);
        this.lzW = this.mRootView.findViewById(R.id.emotion_manager_upload_status);
        this.lzW.setClickable(false);
        this.lzW.setOnClickListener(this);
        this.lzW.setVisibility(8);
        this.iXW = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iXO = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.lzX = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iXX = (TextView) this.mRootView.findViewById(R.id.add_emotion_manager_upload_status);
    }

    public void cCI() {
        if (this.iXU != null) {
            this.iXU.dismiss();
        }
        startAnimation();
        this.lzW.setVisibility(0);
        this.iXL.setVisibility(8);
        ao.setBackgroundColor(this.lzW, R.color.CAM_X0201);
        ao.setImageResource(this.iXW, R.drawable.emotion_uploading_bar_refresh);
        ao.setViewTextColor(this.iXX, R.color.CAM_X0302);
        this.iXX.setText(R.string.emotion_uploading);
        this.lzW.setClickable(false);
    }

    public void cCJ() {
        FaceGroupDraft dkv = com.baidu.tieba.newfaceshop.facemake.e.dku().dkv();
        if (dkv != null && TextUtils.isEmpty(dkv.getFailMsg())) {
            l.showToast(this.mPageContext.getPageActivity(), dkv.getFailMsg());
        }
        Pn(null);
    }

    public void Pn(String str) {
        if (this.iXU != null) {
            this.iXU.dismiss();
        }
        endAnimation();
        this.lzW.setVisibility(0);
        this.iXL.setVisibility(8);
        ao.setBackgroundColor(this.lzW, R.color.CAM_X0201);
        ao.setImageResource(this.iXW, R.drawable.emotion_update_fail);
        ao.setViewTextColor(this.iXX, R.color.common_color_10037);
        if (!TextUtils.isEmpty(str)) {
            this.iXX.setText(str);
        } else {
            this.iXX.setText(R.string.emotion_center_upload_failed);
        }
        this.lzW.setClickable(true);
    }

    public void cCH() {
        if (this.iXU != null) {
            this.iXU.dismiss();
        }
        endAnimation();
        this.lzW.setVisibility(8);
        this.iXL.setVisibility(0);
    }

    public void endAnimation() {
        if (this.iXW != null) {
            this.iXW.clearAnimation();
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iXH == null) {
            this.iXH = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iXH.setInterpolator(new LinearInterpolator());
            this.iXH.setFillAfter(true);
        }
        return this.iXH;
    }

    public void startAnimation() {
        if (this.iXW != null) {
            this.iXW.startAnimation(getClickRotateAnimation());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lzV != null && view.getId() == this.lzV.getId() && this.lzV.isShown()) {
            if (this.lzY == 1) {
                if (this.iXU == null) {
                    this.iXU = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.lzY);
                    this.iXU.a(this);
                }
                this.iXU.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.iXU.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            } else {
                cCy();
            }
        }
        if (this.lzW != null && view.getId() == this.lzW.getId() && this.lzW.isShown()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.lzY == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.iXL != null) {
            ao.setBackgroundColor(this.iXL, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iXX != null) {
            ao.setViewTextColor(this.iXX, R.color.CAM_X0302, i);
        }
        if (this.iXO != null) {
            ao.setImageResource(this.iXO, R.drawable.emotion_bar_add_icon);
        }
        if (this.lzX != null) {
            ao.setViewTextColor(this.lzX, R.color.CAM_X0302, i);
        }
        if (this.lzW != null) {
            ao.setBackgroundColor(this.lzW, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iXW != null) {
            ao.setImageResource(this.iXW, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void onDestroy() {
        if (this.iXU != null && this.iXU.isShowing()) {
            this.iXU.dismiss();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cCx() {
        com.baidu.tieba.newfaceshop.a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dkd = com.baidu.tieba.newfaceshop.c.dkc().dkd();
                final int size = dkd == null ? 0 : dkd.size();
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.1.1
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
    public void cCy() {
        com.baidu.tieba.newfaceshop.a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dkd = com.baidu.tieba.newfaceshop.c.dkc().dkd();
                final int size = dkd == null ? 0 : dkd.size();
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.2.1
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
