package com.baidu.yuyinala.privatemessage.session.viewholder;

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
/* loaded from: classes10.dex */
public class a {
    private TextView eKp;
    private TextView gFj;
    private TextView gFl;
    private HeadImageView hEP;
    public View mtH;
    private TagView pof;
    private TextView pog;
    private j poh;

    public a(View view) {
        this.mtH = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.poh = jVar;
            String str = h.enk().enl().get(h.encode(jVar.pmc + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eKp.setText(str);
            } else {
                this.eKp.setText(jVar.name);
            }
            this.gFj.setText(jVar.description);
            this.gFl.setText(jVar.plU);
            this.hEP.setIsRound(true);
            this.hEP.startLoad(this.poh.iconUrl, 12, false);
            if (jVar.pme != null) {
                this.pof.setText(jVar.pme);
                this.pof.setVisibility(0);
            } else {
                this.pof.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.viewholder.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.pog.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
        }
    }

    private void initView() {
        this.hEP = (HeadImageView) this.mtH.findViewById(a.f.user_message_item_icon);
        this.eKp = (TextView) this.mtH.findViewById(a.f.user_message_item_name);
        this.gFj = (TextView) this.mtH.findViewById(a.f.user_message_item_description);
        this.gFl = (TextView) this.mtH.findViewById(a.f.user_message_item_time);
        this.pof = (TagView) this.mtH.findViewById(a.f.user_message_item_new_count);
        this.pog = (TextView) this.mtH.findViewById(a.f.yuyin_tv_chatlist_shield_status);
    }
}
