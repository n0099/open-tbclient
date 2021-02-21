package com.baidu.tieba.yuyinala.charm.bannedpost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.live.utils.m;
import com.baidu.tieba.yuyinala.charm.bannedpost.a;
import com.baidu.tieba.yuyinala.charm.bannedpost.f;
import com.baidu.tieba.yuyinala.charm.bannedpost.g;
/* loaded from: classes11.dex */
public class BannedPostItemView extends LinearLayout {
    public TextView aDM;
    public HeadImageView gPH;
    private String mGroupId;
    private String mLiveId;
    private String mRoomId;
    private int mType;
    private String mUserName;
    private TextView mdj;
    private a oqf;
    private a.C0914a oqg;

    /* loaded from: classes11.dex */
    public interface a {
        void VO(String str);
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
        this.oqg = c0914a;
        this.mUserName = c0914a.user_name;
        this.aDM.setText(this.mUserName);
        m.a(this.gPH, c0914a.bd_portrait, true, false);
        this.mdj.setVisibility(0);
        this.mdj.setText("取消禁言");
        this.mdj.setTextColor(getResources().getColor(a.c.yuyin_ala_attention_checked_color));
        this.mdj.setBackgroundResource(a.e.yuyin_round_charm_item_attention_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eao() {
        if (this.oqg != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getContext());
            } else if (this.mType == 1) {
                g gVar = new g(getContext());
                gVar.show();
                gVar.setText("确定取消" + this.mUserName + "本场禁言吗？");
                gVar.VP(PayHelper.STATUS_CANCEL_DESC);
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
                                if (BannedPostItemView.this.oqf != null) {
                                    BannedPostItemView.this.oqf.VO(BannedPostItemView.this.oqg.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消本场禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void A(int i, String str) {
                            }
                        });
                        fVar.l(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.oqg.uk, 8);
                    }
                });
            } else if (this.mType == 2) {
                g gVar2 = new g(getContext());
                gVar2.show();
                gVar2.setText("确定取消" + this.mUserName + "永久禁言吗？");
                gVar2.VP(PayHelper.STATUS_CANCEL_DESC);
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
                                if (BannedPostItemView.this.oqf != null) {
                                    BannedPostItemView.this.oqf.VO(BannedPostItemView.this.oqg.uk);
                                }
                                BdUtilHelper.showToast(BannedPostItemView.this.getContext(), BannedPostItemView.this.mUserName + "已被取消永久禁言", 3000);
                            }

                            @Override // com.baidu.tieba.yuyinala.charm.bannedpost.f.a
                            public void A(int i, String str) {
                            }
                        });
                        fVar.l(BannedPostItemView.this.mLiveId, BannedPostItemView.this.mGroupId, BannedPostItemView.this.oqg.uk, 9);
                    }
                });
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.yuyin_banned_post_item_view, (ViewGroup) this, true);
        setOrientation(0);
        Ge();
        initView();
    }

    private void Ge() {
        this.gPH = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.mdj = (TextView) findViewById(a.f.tv_cancel);
        this.mdj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.bannedpost.BannedPostItemView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannedPostItemView.this.eao();
            }
        });
    }

    private void initView() {
        this.gPH.setAutoChangeStyle(false);
        this.gPH.setDrawBorder(false);
        this.gPH.setIsRound(true);
    }

    public void setCallBack(a aVar) {
        this.oqf = aVar;
    }
}
