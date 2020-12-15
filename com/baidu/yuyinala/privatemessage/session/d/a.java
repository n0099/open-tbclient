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
    private TextView eBQ;
    private TextView guj;
    private TextView gul;
    private HeadImageView hrr;
    public View mhJ;
    public TextView oYA;
    private TextView oYB;
    private j oYC;
    private SwipeListViewScroll oYy;
    private TagView oYz;

    public a(View view) {
        this.mhJ = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.oYC = jVar;
            String str = h.eom().eon().get(h.encode(jVar.oXB + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eBQ.setText(str);
            } else {
                this.eBQ.setText(jVar.name);
            }
            this.guj.setText(jVar.description);
            this.gul.setText(jVar.oXt);
            this.hrr.setIsRound(true);
            this.hrr.startLoad(this.oYC.iconUrl, 12, false);
            if (jVar.oXD != null) {
                this.oYz.setText(jVar.oXD);
                this.oYz.setVisibility(0);
            } else {
                this.oYz.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.d.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.oYB.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
            this.oYy.close();
        }
    }

    private void initView() {
        this.oYy = (SwipeListViewScroll) this.mhJ.findViewById(a.f.yuyin_user_message_item_root);
        this.hrr = (HeadImageView) this.mhJ.findViewById(a.f.user_message_item_icon);
        this.eBQ = (TextView) this.mhJ.findViewById(a.f.user_message_item_name);
        this.guj = (TextView) this.mhJ.findViewById(a.f.user_message_item_description);
        this.gul = (TextView) this.mhJ.findViewById(a.f.user_message_item_time);
        this.oYz = (TagView) this.mhJ.findViewById(a.f.user_message_item_new_count);
        this.oYB = (TextView) this.mhJ.findViewById(a.f.yuyin_tv_chatlist_shield_status);
        this.oYA = (TextView) this.mhJ.findViewById(a.f.yuyin_tv_chatlist_delete);
    }
}
