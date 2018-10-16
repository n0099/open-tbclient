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
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private BdUniqueId axF;
    private TbPageContext<BaseFragmentActivity> dlY;
    private String gob;
    private PersonPostModel gpd;
    private PersonPostModel.a gxO;
    private final PersonPostModel.a gxP = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.gpd = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.gpd.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.gpd != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.gpd.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.gxO != null) {
                g.this.gxO.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0260a gxQ = new a.InterfaceC0260a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0260a
        public void bJ(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == e.g.portrait) {
                ((BaseFragmentActivity) g.this.dlY.getOrignalPage()).finish();
            } else if (id == e.g.username) {
                ((BaseFragmentActivity) g.this.dlY.getOrignalPage()).finish();
            } else if ((id == e.g.item_header || id == e.g.original_post_title || id == e.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.dlY.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.dlY.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.dlY = tbPageContext;
        this.mUid = str;
        this.axF = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gxO = aVar;
    }

    public void mq(boolean z) {
        if (this.gpd == null) {
            this.gpd = new PersonPostModel(this.dlY, this.axF, null, true, PersonPostModel.FROM_PERSON_POST);
            this.gpd.setUniqueId(this.axF);
        }
        this.gpd.fetchPost(this.dlY, this.gxP, z, this.mUid, false, true, false);
    }

    public void aBV() {
        if (this.gpd != null) {
            this.gpd.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gpd == null || this.gpd.postList == null) {
            return 0;
        }
        return this.gpd.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.dlY);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gqn.setVisibility(0);
        } else {
            aVar.gqn.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList sG(int i) {
        return (PersonPostModel.PostInfoList) this.gpd.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList sG = sG(i);
        if (this.gob == null) {
            this.gob = sG.user_portrait;
        }
        aVar.a(sG, false, this.gob);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = sG.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (sG.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!sG.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = sG.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(sG.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(sG.thread_id), String.valueOf(sG.content[i2].post_id), String.valueOf(sG.content[i2].post_type), ao.C(sG.content[i2].create_time * 1000), String.valueOf(sG.thread_type)});
            }
        }
        aVar.gxS.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(sG.title).find()) {
            aVar.gqg.setText(sG.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gqg.setText(sG.title);
        }
        if (sG.originalThreadInfo != null && !StringUtils.isNull(sG.originalThreadInfo.showText)) {
            aVar.gqg.setText("分享：" + sG.originalThreadInfo.showText);
        }
        aVar.gqg.setTag(new String[]{String.valueOf(sG.thread_id), null, null, String.valueOf(sG.thread_type)});
        if (sG.thread_type == 33) {
            aVar.gqg.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gqg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.i(aVar.gqg, e.f.person_post_line);
        al.c(aVar.gqg, e.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(e.C0175e.ds20);
        aVar.gqg.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gxQ);
        aVar.dW(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cNG;
        private View czB;
        public TextView gqg;
        public ReplyLinearLayout gxS;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gxS = (ReplyLinearLayout) view.findViewById(e.g.content_container);
            this.gqg = (TextView) view.findViewById(e.g.original_post_title);
            this.cNG = view.findViewById(e.g.reply_top_line);
            this.czB = view.findViewById(e.g.reply_bottom_line);
            this.gqg.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void dW(int i) {
            super.dW(i);
            al.i(this.gqg, e.d.cp_bg_line_e);
            al.c(this.gqg, e.d.cp_cont_b, 1);
            al.i(this.cNG, e.d.cp_bg_line_b);
            al.i(this.czB, e.d.cp_bg_line_b);
        }
    }
}
