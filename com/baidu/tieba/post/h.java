package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private BdUniqueId brl;
    private TbPageContext<BaseFragmentActivity> dul;
    private String gnU;
    private PersonPostModel goU;
    private PersonPostModel.a gxq;
    private final PersonPostModel.a gxr = new PersonPostModel.a() { // from class: com.baidu.tieba.post.h.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                h.this.goU = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.i> it = h.this.goU.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.i next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (h.this.goU != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        h.this.goU.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (h.this.gxq != null) {
                h.this.gxq.b(personPostModel, z);
            }
            h.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0221a gxs = new a.InterfaceC0221a() { // from class: com.baidu.tieba.post.h.2
        @Override // com.baidu.tieba.post.a.InterfaceC0221a
        public void cJ(View view) {
            String[] strArr;
            boolean z;
            int id = view.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) h.this.dul.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) h.this.dul.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if (strArr.length < 4 || strArr[3] == null || com.baidu.adp.lib.g.b.h(strArr[3], 0) != 33) {
                    z = false;
                } else if ("0".equals(strArr[2]) || strArr[1] == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(h.this.dul.getPageActivity(), strArr[0]).xD()));
                    z = true;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveCommentActivityConfig(h.this.dul.getPageActivity()).createPhotoLiveCommentActivityConfig(strArr[0], strArr[1], false)));
                    z = true;
                }
                if (!z) {
                    if ("0".equals(strArr[2]) || strArr[1] == null) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.dul.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                        createNormalCfg.setStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                        return;
                    }
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(h.this.dul.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                    createSubPbActivityConfig.setKeyPageStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                }
            }
        }
    };
    private final String mUid;

    public h(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.dul = tbPageContext;
        this.mUid = str;
        this.brl = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gxq = aVar;
    }

    public void lX(boolean z) {
        if (this.goU == null) {
            this.goU = new PersonPostModel(this.dul, this.brl, null, true, PersonPostModel.FROM_PERSON_POST);
            this.goU.setUniqueId(this.brl);
        }
        this.goU.fetchPost(this.dul, this.gxr, z, this.mUid, false, true, false);
    }

    public void awQ() {
        if (this.goU != null) {
            this.goU.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.goU == null || this.goU.postList == null) {
            return 0;
        }
        return this.goU.postList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.dul);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gqo.setVisibility(0);
        } else {
            aVar.gqo.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList tY(int i) {
        return (PersonPostModel.PostInfoList) this.goU.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList tY = tY(i);
        if (this.gnU == null) {
            this.gnU = tY.user_portrait;
        }
        aVar.a(tY, false, this.gnU);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = tY.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (tY.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!tY.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = tY.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(tY.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(tY.thread_id), String.valueOf(tY.content[i2].post_id), String.valueOf(tY.content[i2].post_type), am.z(tY.content[i2].create_time * 1000), String.valueOf(tY.thread_type)});
            }
        }
        aVar.gxu.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(tY.title).find()) {
            aVar.gqh.setText(tY.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gqh.setText(tY.title);
        }
        if (tY.originalThreadInfo != null && !StringUtils.isNull(tY.originalThreadInfo.showText)) {
            aVar.gqh.setText("分享：" + tY.originalThreadInfo.showText);
        }
        aVar.gqh.setTag(new String[]{String.valueOf(tY.thread_id), null, null, String.valueOf(tY.thread_type)});
        if (tY.thread_type == 33) {
            aVar.gqh.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gqh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        aj.s(aVar.gqh, d.f.person_post_line);
        aj.e(aVar.gqh, d.C0141d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.gqh.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gxs);
        aVar.gx(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cIj;
        private View cXA;
        public TextView gqh;
        public ReplyLinearLayout gxu;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gxu = (ReplyLinearLayout) view.findViewById(d.g.content_container);
            this.gqh = (TextView) view.findViewById(d.g.original_post_title);
            this.cXA = view.findViewById(d.g.reply_top_line);
            this.cIj = view.findViewById(d.g.reply_bottom_line);
            this.gqh.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void gx(int i) {
            super.gx(i);
            aj.s(this.gqh, d.C0141d.cp_bg_line_e);
            aj.e(this.gqh, d.C0141d.cp_cont_b, 1);
            aj.s(this.cXA, d.C0141d.cp_bg_line_b);
            aj.s(this.cIj, d.C0141d.cp_bg_line_b);
        }
    }
}
