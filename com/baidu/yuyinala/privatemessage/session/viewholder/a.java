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
    private TextView eGI;
    private TextView gAC;
    private TextView gAE;
    private HeadImageView hyH;
    public View mio;
    private TagView pbl;
    private TextView pbm;
    private j pbn;

    public a(View view) {
        this.mio = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.pbn = jVar;
            String str = h.ekz().ekA().get(h.encode(jVar.oZg + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eGI.setText(str);
            } else {
                this.eGI.setText(jVar.name);
            }
            this.gAC.setText(jVar.description);
            this.gAE.setText(jVar.oYY);
            this.hyH.setIsRound(true);
            this.hyH.startLoad(this.pbn.iconUrl, 12, false);
            if (jVar.oZi != null) {
                this.pbl.setText(jVar.oZi);
                this.pbl.setVisibility(0);
            } else {
                this.pbl.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.viewholder.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.pbm.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
        }
    }

    private void initView() {
        this.hyH = (HeadImageView) this.mio.findViewById(a.f.user_message_item_icon);
        this.eGI = (TextView) this.mio.findViewById(a.f.user_message_item_name);
        this.gAC = (TextView) this.mio.findViewById(a.f.user_message_item_description);
        this.gAE = (TextView) this.mio.findViewById(a.f.user_message_item_time);
        this.pbl = (TagView) this.mio.findViewById(a.f.user_message_item_new_count);
        this.pbm = (TextView) this.mio.findViewById(a.f.yuyin_tv_chatlist_shield_status);
    }
}
