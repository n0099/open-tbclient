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
    public TextView aFA;
    public HeadImageView gxo;
    private TextView lEX;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private int mType;
    private String mUserName;
    private a nSe;
    private a.C0894a nSf;

    /* loaded from: classes4.dex */
    public interface a {
        void Vm(String str);
    }

    public BannedPostItemView(Context context) {
        this(context, null);
        init();
    }

    public BannedPostItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(a.C0894a c0894a, String str, String str2, String str3, int i) {
        this.mType = i;
        this.mRoomId = str3;
        this.mLiveId = str;
        this.mGroupId = str2;
        this.nSf = c0894a;
        this.mUserName = c0894a.user_name;
        this.aFA.setText(this.mUserName);
        l.a(this.gxo, c0894a.bd_portrait, true, false);
        this.lEX.setVisibility(0);
        this.lEX.setText("取消禁言");
        this.lEX.setTextColor(getResources().getColor(a.c.yuyin_ala_attention_checked_color));
        this.lEX.setBackgroundResource(a.e.yuyin_round_charm_item_attention_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXm() {
        if (this.nSf != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getContext());
            } else if (this.mType == 1) {
                g gVar = new g(getContext());
                gVar.show();
                gVar.setText("确定取消" + this.mUserName + "本场禁言吗？");
                gVar.Vn(PayHelper.STATUS_CANCEL_DESC);
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
                                if (BannedPostItemView.this.nSe != null) {
                                    BannedPostItemView.this.nSe.Vm(BannedPostItemView.this.nSf.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消本场禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void t(int i, String str) {
                            }
                        });
                        fVar.g(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.nSf.uk, 8);
                    }
                });
            } else if (this.mType == 2) {
                g gVar2 = new g(getContext());
                gVar2.show();
                gVar2.setText("确定取消" + this.mUserName + "永久禁言吗？");
                gVar2.Vn(PayHelper.STATUS_CANCEL_DESC);
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
                                if (BannedPostItemView.this.nSe != null) {
                                    BannedPostItemView.this.nSe.Vm(BannedPostItemView.this.nSf.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消永久禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void t(int i, String str) {
                            }
                        });
                        fVar.g(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.nSf.uk, 9);
                    }
                });
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_banned_post_item_view, (ViewGroup) this, true);
        setOrientation(0);
        HZ();
        initView();
    }

    private void HZ() {
        this.gxo = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aFA = (TextView) findViewById(a.f.tv_name);
        this.lEX = (TextView) findViewById(a.f.tv_cancel);
        this.lEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannedPostItemView.this.dXm();
            }
        });
    }

    private void initView() {
        this.gxo.setAutoChangeStyle(false);
        this.gxo.setDrawBorder(false);
        this.gxo.setIsRound(true);
    }

    public void setCallBack(a aVar) {
        this.nSe = aVar;
    }
}
