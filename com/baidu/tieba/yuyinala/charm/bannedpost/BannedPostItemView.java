package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.live.utils.l;
import com.baidu.tieba.yuyinala.charm.bannedpost.a;
import com.baidu.tieba.yuyinala.charm.bannedpost.f;
import com.baidu.tieba.yuyinala.charm.bannedpost.g;
/* loaded from: classes4.dex */
public class BannedPostItemView extends LinearLayout {
    public TextView aGv;
    public HeadImageView gFI;
    private TextView lTj;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private int mType;
    private String mUserName;
    private a oiH;
    private a.C0914a oiI;

    /* loaded from: classes4.dex */
    public interface a {
        void Wm(String str);
    }

    public BannedPostItemView(Context context) {
        this(context, null);
        init();
    }

    public BannedPostItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(a.C0914a c0914a, String str, String str2, String str3, int i) {
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.oiI = c0914a;
        this.mUserName = c0914a.user_name;
        this.aGv.setText(this.mUserName);
        l.a(this.gFI, c0914a.bd_portrait, true, false);
        this.lTj.setVisibility(0);
        this.lTj.setText("取消禁言");
        this.lTj.setTextColor(getResources().getColor(a.c.yuyin_ala_attention_checked_color));
        this.lTj.setBackgroundResource(a.e.yuyin_round_charm_item_attention_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecQ() {
        if (this.oiI != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getContext());
            } else if (this.mType == 1) {
                g gVar = new g(getContext());
                gVar.show();
                gVar.setText("确定取消" + this.mUserName + "本场禁言吗？");
                gVar.Wn(PayHelper.STATUS_CANCEL_DESC);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.1
                    @Override // com.baidu.tieba.yuyinala.charm.bannedpost.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.charm.bannedpost.g.a
                    public void onConfirm() {
                        f fVar = new f(BannedPostItemView.this.getContext());
                        fVar.a(new f.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.1.1
                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void a(com.baidu.tieba.yuyinala.charm.bannedpost.a aVar) {
                                if (BannedPostItemView.this.oiH != null) {
                                    BannedPostItemView.this.oiH.Wm(BannedPostItemView.this.oiI.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消本场禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void t(int i, String str) {
                            }
                        });
                        fVar.g(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.oiI.uk, 8);
                    }
                });
            } else if (this.mType == 2) {
                g gVar2 = new g(getContext());
                gVar2.show();
                gVar2.setText("确定取消" + this.mUserName + "永久禁言吗？");
                gVar2.Wn(PayHelper.STATUS_CANCEL_DESC);
                gVar2.a(new g.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.2
                    @Override // com.baidu.tieba.yuyinala.charm.bannedpost.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.charm.bannedpost.g.a
                    public void onConfirm() {
                        f fVar = new f(BannedPostItemView.this.getContext());
                        fVar.a(new f.a() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.2.1
                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void a(com.baidu.tieba.yuyinala.charm.bannedpost.a aVar) {
                                if (BannedPostItemView.this.oiH != null) {
                                    BannedPostItemView.this.oiH.Wm(BannedPostItemView.this.oiI.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消永久禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void t(int i, String str) {
                            }
                        });
                        fVar.g(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.oiI.uk, 9);
                    }
                });
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_banned_post_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Jh();
        initView();
    }

    private void Jh() {
        this.gFI = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.lTj = (TextView) findViewById(a.f.tv_cancel);
        this.lTj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannedPostItemView.this.ecQ();
            }
        });
    }

    private void initView() {
        this.gFI.setAutoChangeStyle(false);
        this.gFI.setDrawBorder(false);
        this.gFI.setIsRound(true);
    }

    public void setCallBack(a aVar) {
        this.oiH = aVar;
    }
}
