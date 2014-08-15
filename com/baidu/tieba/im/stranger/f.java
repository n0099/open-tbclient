package com.baidu.tieba.im.stranger;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private List<ImMessageCenterShowItemData> a = new ArrayList();
    private StrangerListActivity b;

    public f(StrangerListActivity strangerListActivity) {
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
        g b;
        if (view != null) {
            b = (g) view.getTag();
        } else {
            view = LayoutInflater.from(this.b).inflate(v.chat_list_item, viewGroup, false);
            b = b(view);
            view.setTag(b);
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            ay.e(view, t.list_selector_1);
        } else {
            ay.e(view, t.list_selector);
        }
        ay.f(b.g, r.cp_bg_line_b);
        b.h.setVisibility(0);
        b.g.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i);
        if (item != null) {
            b.c.setText(item.getFriendName());
            b.d.setText(item.getMsgContent());
            a(b, item);
            if (item.getServerTime() != 0) {
                b.e.setText(ba.f(new Date(item.getServerTime())));
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
                textView.setBackgroundResource(t.icon_news_list_prompt_1);
                textView.setText("");
            } else if (i2 < 10) {
                textView.setBackgroundResource(t.icon_news_head_prompt_one_1);
                textView.setText(String.valueOf(i2));
            } else if (i2 < 100) {
                textView.setBackgroundResource(t.icon_news_head_prompt_two_1);
                textView.setText(String.valueOf(i2));
            } else {
                textView.setBackgroundResource(t.icon_news_head_prompt_more_1);
                textView.setText("");
            }
            textView.setTextColor(this.b.getResources().getColor(r.top_msg_num_night));
            return;
        }
        if (i2 == 0) {
            textView.setBackgroundResource(t.icon_news_list_prompt);
            textView.setText("");
        } else if (i2 < 10) {
            textView.setBackgroundResource(t.icon_news_head_prompt_one);
            textView.setText(String.valueOf(i2));
        } else if (i2 < 100) {
            textView.setBackgroundResource(t.icon_news_head_prompt_two);
            textView.setText(String.valueOf(i2));
        } else {
            textView.setBackgroundResource(t.icon_news_head_prompt_more);
            textView.setText("");
        }
        textView.setTextColor(this.b.getResources().getColor(r.top_msg_num_day));
    }

    private void a(ImageView imageView, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null && imageView != null) {
            if (imMessageCenterShowItemData.getGroupSetting() == null) {
                imageView.setVisibility(8);
            } else if (!imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                imageView.setVisibility(0);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    imageView.setImageResource(t.icon_news_stop_1);
                } else {
                    imageView.setImageResource(t.icon_news_stop);
                }
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    private g b(View view) {
        g gVar = new g(null);
        gVar.a = (HeadImageView) view.findViewById(u.chat_head);
        gVar.b = (TextView) view.findViewById(u.new_message);
        gVar.c = (TextView) view.findViewById(u.chat_name);
        gVar.d = (TextView) view.findViewById(u.last_chat_content);
        gVar.e = (TextView) view.findViewById(u.chat_time);
        gVar.f = (ImageView) view.findViewById(u.iv_bell);
        gVar.g = view.findViewById(u.line);
        gVar.h = (ViewGroup) view.findViewById(u.list_content);
        gVar.i = (ImageView) view.findViewById(u.send_status);
        return gVar;
    }

    public void a(List<ImMessageCenterShowItemData> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    private void a(g gVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (gVar != null && imMessageCenterShowItemData != null) {
            gVar.i.setVisibility(0);
            if (imMessageCenterShowItemData.getSendStatus() == 2) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    gVar.i.setBackgroundResource(t.icon_send_failed_information_1);
                } else {
                    gVar.i.setBackgroundResource(t.icon_send_failed_information);
                }
            } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    gVar.i.setBackgroundResource(t.icon_send_in_information_1);
                } else {
                    gVar.i.setBackgroundResource(t.icon_send_in_information);
                }
            } else if (imMessageCenterShowItemData.getSendStatus() == 3) {
                gVar.i.setVisibility(8);
            } else {
                gVar.i.setVisibility(8);
            }
        }
    }
}
