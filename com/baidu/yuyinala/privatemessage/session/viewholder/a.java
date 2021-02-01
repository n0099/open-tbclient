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
    private TextView gDm;
    private TextView gDo;
    private HeadImageView hCS;
    public View mrp;
    private TagView plA;
    private TextView plB;
    private j plC;

    public a(View view) {
        this.mrp = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.plC = jVar;
            String str = h.emR().emS().get(h.encode(jVar.pjw + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eIO.setText(str);
            } else {
                this.eIO.setText(jVar.name);
            }
            this.gDm.setText(jVar.description);
            this.gDo.setText(jVar.pjo);
            this.hCS.setIsRound(true);
            this.hCS.startLoad(this.plC.iconUrl, 12, false);
            if (jVar.pjy != null) {
                this.plA.setText(jVar.pjy);
                this.plA.setVisibility(0);
            } else {
                this.plA.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.viewholder.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.plB.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
        }
    }

    private void initView() {
        this.hCS = (HeadImageView) this.mrp.findViewById(a.f.user_message_item_icon);
        this.eIO = (TextView) this.mrp.findViewById(a.f.user_message_item_name);
        this.gDm = (TextView) this.mrp.findViewById(a.f.user_message_item_description);
        this.gDo = (TextView) this.mrp.findViewById(a.f.user_message_item_time);
        this.plA = (TagView) this.mrp.findViewById(a.f.user_message_item_new_count);
        this.plB = (TextView) this.mrp.findViewById(a.f.yuyin_tv_chatlist_shield_status);
    }
}
