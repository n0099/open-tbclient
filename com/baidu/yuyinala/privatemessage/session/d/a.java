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
    private TextView euO;
    private TextView glY;
    private TextView gma;
    private HeadImageView hhM;
    public View lTC;
    private SwipeListViewScroll oJq;
    private TagView oJr;
    public TextView oJs;
    private TextView oJt;
    private j oJu;

    public a(View view) {
        this.lTC = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.oJu = jVar;
            String str = h.eiv().eiw().get(h.encode(jVar.oIt + ""));
            if (!TextUtils.isEmpty(str)) {
                this.euO.setText(str);
            } else {
                this.euO.setText(jVar.name);
            }
            this.glY.setText(jVar.description);
            this.gma.setText(jVar.oIl);
            this.hhM.setIsRound(true);
            this.hhM.startLoad(this.oJu.iconUrl, 12, false);
            if (jVar.oIv != null) {
                this.oJr.setText(jVar.oIv);
                this.oJr.setVisibility(0);
            } else {
                this.oJr.setVisibility(8);
            }
            IMBoxManager.getShield(TbadkCoreApplication.getInst().getContext(), jVar.contacter, new IGetShieldAndTopListener() { // from class: com.baidu.yuyinala.privatemessage.session.d.a.1
                @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                    a.this.oJt.setVisibility(getShieldAndTopResult.getShield() == 1 ? 0 : 8);
                }
            });
            this.oJq.close();
        }
    }

    private void initView() {
        this.oJq = (SwipeListViewScroll) this.lTC.findViewById(a.f.yuyin_user_message_item_root);
        this.hhM = (HeadImageView) this.lTC.findViewById(a.f.user_message_item_icon);
        this.euO = (TextView) this.lTC.findViewById(a.f.user_message_item_name);
        this.glY = (TextView) this.lTC.findViewById(a.f.user_message_item_description);
        this.gma = (TextView) this.lTC.findViewById(a.f.user_message_item_time);
        this.oJr = (TagView) this.lTC.findViewById(a.f.user_message_item_new_count);
        this.oJt = (TextView) this.lTC.findViewById(a.f.yuyin_tv_chatlist_shield_status);
        this.oJs = (TextView) this.lTC.findViewById(a.f.yuyin_tv_chatlist_delete);
    }
}
