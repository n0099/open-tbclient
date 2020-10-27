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
    public TextView aEK;
    public HeadImageView grA;
    private TextView lzb;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private int mType;
    private String mUserName;
    private a nMk;
    private a.C0879a nMl;

    /* loaded from: classes4.dex */
    public interface a {
        void UV(String str);
    }

    public BannedPostItemView(Context context) {
        this(context, null);
        init();
    }

    public BannedPostItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(a.C0879a c0879a, String str, String str2, String str3, int i) {
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.nMl = c0879a;
        this.mUserName = c0879a.user_name;
        this.aEK.setText(this.mUserName);
        l.a(this.grA, c0879a.bd_portrait, true, false);
        this.lzb.setVisibility(0);
        this.lzb.setText("取消禁言");
        this.lzb.setTextColor(getResources().getColor(a.d.yuyin_ala_attention_checked_color));
        this.lzb.setBackgroundResource(a.f.yuyin_round_charm_item_attention_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUM() {
        if (this.nMl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getContext());
            } else if (this.mType == 1) {
                g gVar = new g(getContext());
                gVar.show();
                gVar.setText("确定取消" + this.mUserName + "本场禁言吗？");
                gVar.UW(PayHelper.STATUS_CANCEL_DESC);
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
                                if (BannedPostItemView.this.nMk != null) {
                                    BannedPostItemView.this.nMk.UV(BannedPostItemView.this.nMl.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消本场禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void t(int i, String str) {
                            }
                        });
                        fVar.g(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.nMl.uk, 8);
                    }
                });
            } else if (this.mType == 2) {
                g gVar2 = new g(getContext());
                gVar2.show();
                gVar2.setText("确定取消" + this.mUserName + "永久禁言吗？");
                gVar2.UW(PayHelper.STATUS_CANCEL_DESC);
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
                                if (BannedPostItemView.this.nMk != null) {
                                    BannedPostItemView.this.nMk.UV(BannedPostItemView.this.nMl.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消永久禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void t(int i, String str) {
                            }
                        });
                        fVar.g(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.nMl.uk, 9);
                    }
                });
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.yuyin_banned_post_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Hy();
        initView();
    }

    private void Hy() {
        this.grA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.aEK = (TextView) findViewById(a.g.tv_name);
        this.lzb = (TextView) findViewById(a.g.tv_cancel);
        this.lzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannedPostItemView.this.dUM();
            }
        });
    }

    private void initView() {
        this.grA.setAutoChangeStyle(false);
        this.grA.setDrawBorder(false);
        this.grA.setIsRound(true);
    }

    public void setCallBack(a aVar) {
        this.nMk = aVar;
    }
}
