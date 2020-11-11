package com.baidu.yuyinala.privatemessage.session.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.shield.IGetShieldAndTopListener;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.yuyinala.privatemessage.session.b.h;
import com.baidu.yuyinala.privatemessage.session.b.j;
import com.baidu.yuyinala.privatemessage.session.util.TagView;
import com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll;
/* loaded from: classes4.dex */
public class a {
    private TextView ewx;
    private TextView gmr;
    private TextView gmt;
    private HeadImageView hig;
    public View lTm;
    private SwipeListViewScroll oHM;
    private TagView oHN;
    public TextView oHO;
    private TextView oHP;
    private j oHQ;

    public a(View view) {
        this.lTm = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.oHQ = jVar;
            String str = h.eix().eiy().get(h.encode(jVar.oGP + ""));
            if (!TextUtils.isEmpty(str)) {
                this.ewx.setText(str);
            } else {
                this.ewx.setText(jVar.name);
            }
            this.gmr.setText(jVar.description);
            this.gmt.setText(jVar.oGH);
            this.hig.setIsRound(true);
            this.hig.startLoad(this.oHQ.iconUrl, 12, false);
            if (jVar.oGR != null) {
                this.oHN.setText(jVar.oGR);
                this.oHN.setVisibility(0);
            } else {
                this.oHN.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.d.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.oHP.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
            this.oHM.close();
        }
    }

    private void initView() {
        this.oHM = (SwipeListViewScroll) this.lTm.findViewById(a.f.yuyin_user_message_item_root);
        this.hig = (HeadImageView) this.lTm.findViewById(a.f.user_message_item_icon);
        this.ewx = (TextView) this.lTm.findViewById(a.f.user_message_item_name);
        this.gmr = (TextView) this.lTm.findViewById(a.f.user_message_item_description);
        this.gmt = (TextView) this.lTm.findViewById(a.f.user_message_item_time);
        this.oHN = (TagView) this.lTm.findViewById(a.f.user_message_item_new_count);
        this.oHP = (TextView) this.lTm.findViewById(a.f.yuyin_tv_chatlist_shield_status);
        this.oHO = (TextView) this.lTm.findViewById(a.f.yuyin_tv_chatlist_delete);
    }
}
