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
    private TextView guh;
    private TextView guj;
    private HeadImageView hrp;
    public View mhH;
    private j oYA;
    private SwipeListViewScroll oYw;
    private TagView oYx;
    public TextView oYy;
    private TextView oYz;

    public a(View view) {
        this.mhH = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.oYA = jVar;
            String str = h.eol().eom().get(h.encode(jVar.oXz + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eBQ.setText(str);
            } else {
                this.eBQ.setText(jVar.name);
            }
            this.guh.setText(jVar.description);
            this.guj.setText(jVar.oXr);
            this.hrp.setIsRound(true);
            this.hrp.startLoad(this.oYA.iconUrl, 12, false);
            if (jVar.oXB != null) {
                this.oYx.setText(jVar.oXB);
                this.oYx.setVisibility(0);
            } else {
                this.oYx.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.d.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.oYz.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
            this.oYw.close();
        }
    }

    private void initView() {
        this.oYw = (SwipeListViewScroll) this.mhH.findViewById(a.f.yuyin_user_message_item_root);
        this.hrp = (HeadImageView) this.mhH.findViewById(a.f.user_message_item_icon);
        this.eBQ = (TextView) this.mhH.findViewById(a.f.user_message_item_name);
        this.guh = (TextView) this.mhH.findViewById(a.f.user_message_item_description);
        this.guj = (TextView) this.mhH.findViewById(a.f.user_message_item_time);
        this.oYx = (TagView) this.mhH.findViewById(a.f.user_message_item_new_count);
        this.oYz = (TextView) this.mhH.findViewById(a.f.yuyin_tv_chatlist_shield_status);
        this.oYy = (TextView) this.mhH.findViewById(a.f.yuyin_tv_chatlist_delete);
    }
}
