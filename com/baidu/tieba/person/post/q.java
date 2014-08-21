package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements b, g {
    public PersonPostModel a;
    private r b;
    private final String c;
    private String d;
    private final BaseFragmentActivity e;

    public q(Context context, String str, String str2) {
        this.e = (BaseFragmentActivity) context;
        this.c = str;
    }

    public void a(boolean z) {
        if (this.a == null) {
            this.a = new PersonPostModel();
        }
        this.a.fetchPost(this.e, this, z, this.c, true);
    }

    public void a() {
        if (this.a != null) {
            this.a.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.person.post.g
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

    public void a(r rVar) {
        this.b = rVar;
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
        s sVar;
        if (view == null) {
            view = com.baidu.adp.lib.e.b.a().a(viewGroup.getContext(), com.baidu.tieba.v.person_post_item_thread, viewGroup, false);
            s sVar2 = new s(view);
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        if (i == 0) {
            sVar.a.setVisibility(0);
        } else {
            sVar.a.setVisibility(8);
        }
        PersonPostModel.PostList postList = this.a.post_list.get(i);
        if (this.d == null) {
            this.d = postList.user_portrait;
        }
        sVar.a(postList, true, this.d);
        String str = postList.title;
        if (str.trim().length() > 0) {
            sVar.h.setText(str);
            sVar.h.setVisibility(0);
        } else {
            sVar.h.setVisibility(8);
        }
        LiveCardData a = a(postList.anchor_info);
        if (a.getAuthorId() != 0) {
            sVar.j.setVisibility(8);
            sVar.l.setVisibility(0);
            sVar.m.setData(a);
        } else {
            sVar.l.setVisibility(8);
            if (com.baidu.tbadk.core.h.a().f() && postList.media != null && postList.media.length > 0) {
                int min = Math.min(postList.media.length, 3);
                PersonPostModel.Media[] mediaArr = new PersonPostModel.Media[min];
                for (int i2 = 0; i2 < min; i2++) {
                    mediaArr[i2] = postList.media[i2];
                }
                sVar.j.setVisibility(0);
                sVar.j.setTags(mediaArr);
            } else {
                sVar.j.setVisibility(8);
                sVar.j.setTags(null);
            }
        }
        if (postList.abs_thread != null && postList.abs_thread.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < postList.abs_thread.length; i3++) {
                sb.append(postList.abs_thread[i3].text);
            }
            String sb2 = sb.toString();
            if (sb2.trim().length() > 0) {
                sVar.i.setText(sb2);
                sVar.i.setVisibility(0);
            } else {
                sVar.i.setVisibility(8);
            }
        } else {
            sVar.i.setVisibility(8);
        }
        if (!sVar.i.isShown() && a.getAuthorId() != 0) {
            sVar.k.setVisibility(8);
        } else {
            sVar.k.setVisibility(0);
        }
        sVar.a(this);
        sVar.a(TbadkApplication.m252getInst().getSkinType());
        ay.f(sVar.n, com.baidu.tieba.r.cp_bg_line_b);
        sVar.m.a(TbadkApplication.m252getInst().getSkinType());
        this.e.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.e.c().a(sVar.g);
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

    @Override // com.baidu.tieba.person.post.b
    public void a(View view) {
        String[] strArr;
        int id = view.getId();
        if (id == com.baidu.tieba.u.forum_name) {
            String str = (String) view.getTag();
            if (str != null && (this.e instanceof BaseFragmentActivity)) {
                this.e.a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.e).a(str, "")));
            }
        } else if (id == com.baidu.tieba.u.portrait) {
            this.e.finish();
        } else if (id == com.baidu.tieba.u.username) {
            this.e.finish();
        } else if ((id == com.baidu.tieba.u.item_content || id == com.baidu.tieba.u.item_header || id == com.baidu.tieba.u.item_footer) && (strArr = (String[]) view.getTag()) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bc(this.e).a(strArr[0], strArr[1], "person_post", 18005)));
        }
    }
}
