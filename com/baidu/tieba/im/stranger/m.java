package com.baidu.tieba.im.stranger;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private List<ImMessageCenterShowItemData> a = new ArrayList();
    private StrangerListActivity b;

    public m(StrangerListActivity strangerListActivity) {
        this.b = strangerListActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i) {
        if (i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.a.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        n b;
        if (view != null) {
            b = (n) view.getTag();
        } else {
            view = LayoutInflater.from(this.b).inflate(w.chat_list_item, viewGroup, false);
            b = b(view);
            view.setTag(b);
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            bk.e(view, com.baidu.tieba.u.list_selector_1);
        } else {
            bk.e(view, com.baidu.tieba.u.list_selector);
        }
        bk.f(b.g, com.baidu.tieba.s.cp_bg_line_b);
        b.h.setVisibility(0);
        b.g.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i);
        if (item != null) {
            b.c.setText(item.getFriendName());
            b.d.setText(item.getMsgContent());
            if (item.getServerTime() != 0) {
                b.e.setText(bm.f(new Date(item.getServerTime())));
            }
            b.f.setVisibility(8);
            if (item.getUnReadCount() > 0) {
                b.b.setVisibility(0);
                a(item, b.b, item.getUnReadCount());
            } else {
                b.b.setVisibility(8);
            }
            a(b.f, item);
            b.a.setDrawBorder(true);
            b.a.setDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
            b.a.setNightDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
            b.a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            if (!TextUtils.isEmpty(item.getFriendPortrait())) {
                b.a.a(item.getFriendPortrait(), 12, false);
            }
        }
        a(view);
        return view;
    }

    private void a(View view) {
        this.b.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.b.getLayoutMode().a(view);
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData, TextView textView, int i) {
        if (TbadkApplication.m252getInst().getMsgFrequency() == 0) {
            i = 0;
        }
        if (!TbadkApplication.m252getInst().isMsgChatOn()) {
            i = 0;
        }
        int i2 = imMessageCenterShowItemData.getGroupSetting().isAcceptNotify() ? i : 0;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (i2 == 0) {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_list_prompt_1);
                textView.setText("");
            } else if (i2 < 10) {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one_1);
                textView.setText(String.valueOf(i2));
            } else if (i2 < 100) {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_two_1);
                textView.setText(String.valueOf(i2));
            } else {
                textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_more_1);
                textView.setText("");
            }
            textView.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.top_msg_num_night));
            return;
        }
        if (i2 == 0) {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_list_prompt);
            textView.setText("");
        } else if (i2 < 10) {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_one);
            textView.setText(String.valueOf(i2));
        } else if (i2 < 100) {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_two);
            textView.setText(String.valueOf(i2));
        } else {
            textView.setBackgroundResource(com.baidu.tieba.u.icon_news_head_prompt_more);
            textView.setText("");
        }
        textView.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.top_msg_num_day));
    }

    private void a(ImageView imageView, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null && imageView != null) {
            if (imMessageCenterShowItemData.getGroupSetting() == null) {
                imageView.setVisibility(8);
            } else if (!imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                imageView.setVisibility(0);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    imageView.setImageResource(com.baidu.tieba.u.icon_news_stop_1);
                } else {
                    imageView.setImageResource(com.baidu.tieba.u.icon_news_stop);
                }
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    private n b(View view) {
        n nVar = new n(null);
        nVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.v.chat_head);
        nVar.b = (TextView) view.findViewById(com.baidu.tieba.v.new_message);
        nVar.c = (TextView) view.findViewById(com.baidu.tieba.v.chat_name);
        nVar.d = (TextView) view.findViewById(com.baidu.tieba.v.last_chat_content);
        nVar.e = (TextView) view.findViewById(com.baidu.tieba.v.chat_time);
        nVar.f = (ImageView) view.findViewById(com.baidu.tieba.v.iv_bell);
        nVar.g = view.findViewById(com.baidu.tieba.v.line);
        nVar.h = (ViewGroup) view.findViewById(com.baidu.tieba.v.list_content);
        return nVar;
    }

    public void a(List<ImMessageCenterShowItemData> list) {
        this.a = list;
        notifyDataSetChanged();
    }
}
