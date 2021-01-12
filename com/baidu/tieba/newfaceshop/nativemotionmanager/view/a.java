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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, com.baidu.tieba.faceshop.emotioncenter.a.c {
    private Animation iTa = null;
    private View iTe;
    private ImageView iTh;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iTn;
    private ImageView iTp;
    private TextView iTq;
    private View lvp;
    private View lvq;
    private TextView lvr;
    private int lvs;
    private TbPageContext mPageContext;
    private View mRootView;

    public a(TbPageContext tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        this.lvs = i;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.emotion_native_manager_create_layout, (ViewGroup) null);
        this.iTe = this.mRootView.findViewById(R.id.emotion_manager_add_layout);
        this.lvp = this.mRootView.findViewById(R.id.emotion_manager_create);
        this.lvp.setOnClickListener(this);
        this.iTe.setVisibility(0);
        this.lvq = this.mRootView.findViewById(R.id.emotion_manager_upload_status);
        this.lvq.setClickable(false);
        this.lvq.setOnClickListener(this);
        this.lvq.setVisibility(8);
        this.iTp = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iTh = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.lvr = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iTq = (TextView) this.mRootView.findViewById(R.id.add_emotion_manager_upload_status);
    }

    public void cyQ() {
        if (this.iTn != null) {
            this.iTn.dismiss();
        }
        startAnimation();
        this.lvq.setVisibility(0);
        this.iTe.setVisibility(8);
        ao.setBackgroundColor(this.lvq, R.color.CAM_X0201);
        ao.setImageResource(this.iTp, R.drawable.emotion_uploading_bar_refresh);
        ao.setViewTextColor(this.iTq, R.color.CAM_X0302);
        this.iTq.setText(R.string.emotion_uploading);
        this.lvq.setClickable(false);
    }

    public void cyR() {
        FaceGroupDraft dgD = com.baidu.tieba.newfaceshop.facemake.e.dgC().dgD();
        if (dgD != null && TextUtils.isEmpty(dgD.getFailMsg())) {
            l.showToast(this.mPageContext.getPageActivity(), dgD.getFailMsg());
        }
        Of(null);
    }

    public void Of(String str) {
        if (this.iTn != null) {
            this.iTn.dismiss();
        }
        endAnimation();
        this.lvq.setVisibility(0);
        this.iTe.setVisibility(8);
        ao.setBackgroundColor(this.lvq, R.color.CAM_X0201);
        ao.setImageResource(this.iTp, R.drawable.emotion_update_fail);
        ao.setViewTextColor(this.iTq, R.color.common_color_10037);
        if (!TextUtils.isEmpty(str)) {
            this.iTq.setText(str);
        } else {
            this.iTq.setText(R.string.emotion_center_upload_failed);
        }
        this.lvq.setClickable(true);
    }

    public void cyP() {
        if (this.iTn != null) {
            this.iTn.dismiss();
        }
        endAnimation();
        this.lvq.setVisibility(8);
        this.iTe.setVisibility(0);
    }

    public void endAnimation() {
        if (this.iTp != null) {
            this.iTp.clearAnimation();
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iTa == null) {
            this.iTa = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iTa.setInterpolator(new LinearInterpolator());
            this.iTa.setFillAfter(true);
        }
        return this.iTa;
    }

    public void startAnimation() {
        if (this.iTp != null) {
            this.iTp.startAnimation(getClickRotateAnimation());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lvp != null && view.getId() == this.lvp.getId() && this.lvp.isShown()) {
            if (this.lvs == 1) {
                if (this.iTn == null) {
                    this.iTn = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.lvs);
                    this.iTn.a(this);
                }
                this.iTn.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                Rect rect = new Rect();
                this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.iTn.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
            } else {
                cyG();
            }
        }
        if (this.lvq != null && view.getId() == this.lvq.getId() && this.lvq.isShown()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.lvs == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        if (this.iTe != null) {
            ao.setBackgroundColor(this.iTe, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iTq != null) {
            ao.setViewTextColor(this.iTq, R.color.CAM_X0302, i);
        }
        if (this.iTh != null) {
            ao.setImageResource(this.iTh, R.drawable.emotion_bar_add_icon);
        }
        if (this.lvr != null) {
            ao.setViewTextColor(this.lvr, R.color.CAM_X0302, i);
        }
        if (this.lvq != null) {
            ao.setBackgroundColor(this.lvq, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iTp != null) {
            ao.setImageResource(this.iTp, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    public void onDestroy() {
        if (this.iTn != null && this.iTn.isShowing()) {
            this.iTn.dismiss();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cyF() {
        com.baidu.tieba.newfaceshop.a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.1
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dgl = com.baidu.tieba.newfaceshop.c.dgk().dgl();
                final int size = dgl == null ? 0 : dgl.size();
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
    public void cyG() {
        com.baidu.tieba.newfaceshop.a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dgl = com.baidu.tieba.newfaceshop.c.dgk().dgl();
                final int size = dgl == null ? 0 : dgl.size();
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
