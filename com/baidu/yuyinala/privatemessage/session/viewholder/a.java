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
    private TextView eIO;
    private TextView gDA;
    private TextView gDC;
    private HeadImageView hDg;
    public View mrE;
    private TagView pma;
    private TextView pmb;
    private j pmc;

    public a(View view) {
        this.mrE = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.pmc = jVar;
            String str = h.emZ().ena().get(h.encode(jVar.pjW + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eIO.setText(str);
            } else {
                this.eIO.setText(jVar.name);
            }
            this.gDA.setText(jVar.description);
            this.gDC.setText(jVar.pjO);
            this.hDg.setIsRound(true);
            this.hDg.startLoad(this.pmc.iconUrl, 12, false);
            if (jVar.pjY != null) {
                this.pma.setText(jVar.pjY);
                this.pma.setVisibility(0);
            } else {
                this.pma.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.viewholder.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.pmb.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
        }
    }

    private void initView() {
        this.hDg = (HeadImageView) this.mrE.findViewById(a.f.user_message_item_icon);
        this.eIO = (TextView) this.mrE.findViewById(a.f.user_message_item_name);
        this.gDA = (TextView) this.mrE.findViewById(a.f.user_message_item_description);
        this.gDC = (TextView) this.mrE.findViewById(a.f.user_message_item_time);
        this.pma = (TagView) this.mrE.findViewById(a.f.user_message_item_new_count);
        this.pmb = (TextView) this.mrE.findViewById(a.f.yuyin_tv_chatlist_shield_status);
    }
}
