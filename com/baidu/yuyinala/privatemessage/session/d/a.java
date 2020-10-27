package com.baidu.yuyinala.privatemessage.session.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.yuyinala.privatemessage.session.b.h;
import com.baidu.yuyinala.privatemessage.session.b.j;
import com.baidu.yuyinala.privatemessage.session.util.TagView;
import com.baidu.yuyinala.privatemessage.session.view.SwipeListViewScroll;
/* loaded from: classes4.dex */
public class a {
    private TextView eqE;
    private TextView ggD;
    private TextView ggF;
    private HeadImageView hck;
    public View lNq;
    private SwipeListViewScroll oyu;
    private TagView oyv;
    public TextView oyw;
    private TextView oyx;
    private j oyy;

    public a(View view) {
        this.lNq = view;
        initView();
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.oyy = jVar;
            String str = h.eeI().eeJ().get(h.encode(jVar.oxw + ""));
            if (!TextUtils.isEmpty(str)) {
                this.eqE.setText(str);
            } else {
                this.eqE.setText(jVar.name);
            }
            this.ggD.setText(jVar.description);
            this.ggF.setText(jVar.oxo);
            this.hck.setIsRound(true);
            this.hck.startLoad(this.oyy.iconUrl, 12, false);
            if (jVar.oxy != null) {
                this.oyv.setText(jVar.oxy);
                this.oyv.setVisibility(0);
            } else {
                this.oyv.setVisibility(8);
            }
            ChatUser chatUserSync = IMBoxManager.getChatUserSync(TbadkCoreApplication.getInst().getContext(), jVar.contacter);
            if (chatUserSync != null) {
                this.oyx.setVisibility(chatUserSync.getBlack() == 1 ? 0 : 8);
            }
            this.oyu.close();
        }
    }

    private void initView() {
        this.oyu = (SwipeListViewScroll) this.lNq.findViewById(a.g.yuyin_user_message_item_root);
        this.hck = (HeadImageView) this.lNq.findViewById(a.g.user_message_item_icon);
        this.eqE = (TextView) this.lNq.findViewById(a.g.user_message_item_name);
        this.ggD = (TextView) this.lNq.findViewById(a.g.user_message_item_description);
        this.ggF = (TextView) this.lNq.findViewById(a.g.user_message_item_time);
        this.oyv = (TagView) this.lNq.findViewById(a.g.user_message_item_new_count);
        this.oyx = (TextView) this.lNq.findViewById(a.g.yuyin_tv_chatlist_shield_status);
        this.oyw = (TextView) this.lNq.findViewById(a.g.yuyin_tv_chatlist_delete);
    }
}
