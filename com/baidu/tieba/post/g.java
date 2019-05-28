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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class g extends BaseAdapter {
    private BdUniqueId Xk;
    private TbPageContext<BaseFragmentActivity> fao;
    private String iiO;
    private PersonPostModel ijQ;
    private PersonPostModel.a itU;
    private final PersonPostModel.a itV = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.ijQ = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.ijQ.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.ijQ != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.ijQ.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.itU != null) {
                g.this.itU.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0389a itW = new a.InterfaceC0389a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0389a
        public void cJ(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.fao.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.fao.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.fao.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.fao.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.fao = tbPageContext;
        this.mUid = str;
        this.Xk = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.itU = aVar;
    }

    public void pU(boolean z) {
        if (this.ijQ == null) {
            this.ijQ = new PersonPostModel(this.fao, this.Xk, null, true, PersonPostModel.FROM_PERSON_POST);
            this.ijQ.setUniqueId(this.Xk);
        }
        this.ijQ.fetchPost(this.fao, this.itV, z, this.mUid, false, true, false);
    }

    public void bmr() {
        if (this.ijQ != null) {
            this.ijQ.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ijQ == null || this.ijQ.postList == null) {
            return 0;
        }
        return this.ijQ.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.fao);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.ila.setVisibility(0);
        } else {
            aVar.ila.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList yA(int i) {
        return (PersonPostModel.PostInfoList) this.ijQ.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList yA = yA(i);
        if (this.iiO == null) {
            this.iiO = yA.user_portrait;
        }
        aVar.a(yA, false, this.iiO);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = yA.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (yA.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!yA.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = yA.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(yA.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(yA.thread_id), String.valueOf(yA.content[i2].post_id), String.valueOf(yA.content[i2].post_type), ap.aC(yA.content[i2].create_time * 1000), String.valueOf(yA.thread_type)});
            }
        }
        aVar.itY.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(yA.title).find()) {
            aVar.ikT.setText(yA.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.ikT.setText(yA.title);
        }
        if (yA.originalThreadInfo != null && !StringUtils.isNull(yA.originalThreadInfo.showText)) {
            aVar.ikT.setText("分享：" + yA.originalThreadInfo.showText);
        }
        aVar.ikT.setTag(new String[]{String.valueOf(yA.thread_id), null, null, String.valueOf(yA.thread_type)});
        if (yA.thread_type == 33) {
            aVar.ikT.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.ikT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        al.k(aVar.ikT, R.drawable.person_post_line);
        al.f(aVar.ikT, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.ikT.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.itW);
        aVar.iP(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View edE;
        private View eyj;
        public TextView ikT;
        public ReplyLinearLayout itY;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.itY = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.ikT = (TextView) view.findViewById(R.id.original_post_title);
            this.eyj = view.findViewById(R.id.reply_top_line);
            this.edE = view.findViewById(R.id.reply_bottom_line);
            this.ikT.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void iP(int i) {
            super.iP(i);
            al.k(this.ikT, R.color.cp_bg_line_e);
            al.f(this.ikT, R.color.cp_cont_b, 1);
            al.k(this.eyj, R.color.cp_bg_line_b);
            al.k(this.edE, R.color.cp_bg_line_b);
        }
    }
}
