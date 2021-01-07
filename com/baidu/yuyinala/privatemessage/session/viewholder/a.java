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
/* loaded from: classes11.dex */
public class a {
    private TextView eLt;
    private TextView gFi;
    private TextView gFk;
    private HeadImageView hDn;
    public View mmS;
    private TagView pfN;
    private TextView pfO;
    private j pfP;

    public a(View view) {
        this.mmS = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.pfP = jVar;
            String str = h.eov().eow().get(h.encode(jVar.pdK + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eLt.setText(str);
            } else {
                this.eLt.setText(jVar.name);
            }
            this.gFi.setText(jVar.description);
            this.gFk.setText(jVar.pdC);
            this.hDn.setIsRound(true);
            this.hDn.startLoad(this.pfP.iconUrl, 12, false);
            if (jVar.pdM != null) {
                this.pfN.setText(jVar.pdM);
                this.pfN.setVisibility(0);
            } else {
                this.pfN.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.viewholder.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.pfO.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
        }
    }

    private void initView() {
        this.hDn = (HeadImageView) this.mmS.findViewById(a.f.user_message_item_icon);
        this.eLt = (TextView) this.mmS.findViewById(a.f.user_message_item_name);
        this.gFi = (TextView) this.mmS.findViewById(a.f.user_message_item_description);
        this.gFk = (TextView) this.mmS.findViewById(a.f.user_message_item_time);
        this.pfN = (TagView) this.mmS.findViewById(a.f.user_message_item_new_count);
        this.pfO = (TextView) this.mmS.findViewById(a.f.yuyin_tv_chatlist_shield_status);
    }
}
