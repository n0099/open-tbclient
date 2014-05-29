package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements c, f {
    public PersonPostModel a;
    private q b;
    private final String c;
    private String d;
    private com.baidu.tbadk.editortool.ab e;
    private final BaseFragmentActivity f;

    public p(Context context, String str, String str2) {
        this.f = (BaseFragmentActivity) context;
        this.c = str;
        this.e = new com.baidu.tbadk.editortool.ab(this.f);
    }

    public void a(boolean z) {
        if (this.a == null) {
            this.a = new PersonPostModel();
        }
        this.a.fetchPost(this.f, this, z, this.c, true);
    }

    public void a() {
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.post.f
    public void a(PersonPostModel personPostModel, boolean z) {
        if (z) {
            this.a = personPostModel;
        } else if (this.a != null) {
            this.a.post_list.addAll(personPostModel.post_list);
        }
        if (this.b != null) {
            this.b.a(personPostModel, z);
        }
        notifyDataSetChanged();
    }

    public void a(q qVar) {
        this.b = qVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.post_list == null) {
            return 0;
        }
        return this.a.post_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.post_list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        r rVar;
        if (view == null) {
            BdLog.d("PersonThreadAdapter", "getView", "create convertView");
            view = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.w.person_post_item_thread, viewGroup, false);
            r rVar2 = new r(view);
            view.setTag(rVar2);
            rVar = rVar2;
        } else {
            rVar = (r) view.getTag();
        }
        if (i == 0) {
            rVar.a.setVisibility(0);
        } else {
            rVar.a.setVisibility(8);
        }
        PersonPostModel.PostList postList = this.a.post_list.get(i);
        if (this.d == null) {
            this.d = postList.user_portrait;
        }
        rVar.a(postList, true, this.d);
        String str = postList.title;
        if (str.trim().length() > 0) {
            rVar.h.setText(str);
            rVar.h.setVisibility(0);
        } else {
            rVar.h.setVisibility(8);
        }
        LiveCardData a = a(postList.anchor_info);
        if (a.getAuthorId() != 0) {
            rVar.j.setVisibility(8);
            rVar.l.setVisibility(0);
            rVar.m.a(a, this.e);
        } else {
            rVar.l.setVisibility(8);
            if (com.baidu.tbadk.core.g.a().f() && postList.media != null && postList.media.length > 0) {
                int min = Math.min(postList.media.length, 3);
                String[] strArr = new String[min];
                for (int i2 = 0; i2 < min; i2++) {
                    strArr[i2] = postList.media[i2].big_pic;
                }
                rVar.j.setVisibility(0);
                rVar.j.setTags(strArr);
            } else {
                rVar.j.setVisibility(8);
                rVar.j.setTags(null);
            }
        }
        if (postList.abs_thread != null && postList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs_thread.length; i3++) {
                sb.append(postList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                rVar.i.setText(sb2);
                rVar.i.setVisibility(0);
            } else {
                rVar.i.setVisibility(8);
            }
        } else {
            rVar.i.setVisibility(8);
        }
        if (!rVar.i.isShown() && a.getAuthorId() != 0) {
            rVar.k.setVisibility(8);
        } else {
            rVar.k.setVisibility(0);
        }
        rVar.a(this);
        rVar.a(TbadkApplication.m252getInst().getSkinType());
        bc.f(rVar.n, com.baidu.tieba.s.cp_bg_line_b);
        rVar.m.a(TbadkApplication.m252getInst().getSkinType());
        this.f.a().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.f.a().a(rVar.g);
        return view;
    }

    private LiveCardData a(PersonPostModel.AnchorInfo anchorInfo) {
        LiveCardData liveCardData = new LiveCardData();
        liveCardData.setAuthorId(anchorInfo.author_id);
        liveCardData.setAuthorName(anchorInfo.author_name);
        liveCardData.setGroupId(anchorInfo.group_id);
        liveCardData.setIntro(anchorInfo.intro);
        liveCardData.setLikers(anchorInfo.likers);
        liveCardData.setListeners(anchorInfo.listeners);
        liveCardData.setName(anchorInfo.name);
        liveCardData.setPortrait(anchorInfo.portrait);
        liveCardData.setPublisherId(anchorInfo.publisherId);
        liveCardData.setPublisherName(anchorInfo.publisherName);
        liveCardData.setStartTime(anchorInfo.start_time);
        liveCardData.setStatus(anchorInfo.status);
        liveCardData.setPublisherPortrait(anchorInfo.publisherPortrait);
        return liveCardData;
    }

    @Override // com.baidu.tieba.person.post.c
    public void a(View view) {
        String[] strArr;
        int id = view.getId();
        if (id == com.baidu.tieba.v.forum_name) {
            String str = (String) view.getTag();
            if (str != null && (this.f instanceof BaseFragmentActivity)) {
                this.f.a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this.f).a(str, "")));
            }
        } else if (id == com.baidu.tieba.v.portrait) {
            this.f.finish();
        } else if (id == com.baidu.tieba.v.username) {
            this.f.finish();
        } else if ((id == com.baidu.tieba.v.item_content || id == com.baidu.tieba.v.item_header || id == com.baidu.tieba.v.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2006001, new as(this.f).a(strArr[0], strArr[1], "person_post", 18003)));
            BdLog.d("PersonThreadAdapter", "on", "start thread = " + strArr[0] + " post_id = " + strArr[1]);
        }
    }
}
