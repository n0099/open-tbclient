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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private BdUniqueId Mh;
    private TbPageContext<BaseFragmentActivity> fXZ;
    private String jip;
    private PersonPostModel jjB;
    private PersonPostModel.a jvw;
    private final PersonPostModel.a jvx = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.jjB = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.jjB.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.jjB != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.jjB.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.jvw != null) {
                g.this.jvw.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0578a jvy = new a.InterfaceC0578a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0578a
        public void cF(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.fXZ.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.fXZ.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.fXZ.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.fXZ.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.fXZ = tbPageContext;
        this.mUid = str;
        this.Mh = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.jvw = aVar;
    }

    public void rD(boolean z) {
        if (this.jjB == null) {
            this.jjB = new PersonPostModel(this.fXZ, this.Mh, null, true, PersonPostModel.FROM_PERSON_POST);
            this.jjB.setUniqueId(this.Mh);
        }
        this.jjB.fetchPost(this.fXZ, this.jvx, z, this.mUid, false, true, false, null);
    }

    public void bDP() {
        if (this.jjB != null) {
            this.jjB.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jjB == null || this.jjB.postList == null) {
            return 0;
        }
        return this.jjB.postList.size();
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
            aVar = new a(view, this.fXZ);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.jlp.setVisibility(0);
        } else {
            aVar.jlp.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Ak(int i) {
        return (PersonPostModel.PostInfoList) this.jjB.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Ak = Ak(i);
        if (this.jip == null) {
            this.jip = Ak.user_portrait;
        }
        aVar.a(Ak, false, this.jip);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Ak.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Ak.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Ak.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Ak.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Ak.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Ak.thread_id), String.valueOf(Ak.content[i2].post_id), String.valueOf(Ak.content[i2].post_type), aq.getFormatTime(Ak.content[i2].create_time * 1000), String.valueOf(Ak.thread_type)});
            }
        }
        aVar.jvA.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Ak.title).find()) {
            aVar.jli.setText(Ak.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.jli.setText(Ak.title);
        }
        if (Ak.originalThreadInfo != null && !StringUtils.isNull(Ak.originalThreadInfo.showText)) {
            aVar.jli.setText("分享：" + Ak.originalThreadInfo.showText);
        }
        aVar.jli.setTag(new String[]{String.valueOf(Ak.thread_id), null, null, String.valueOf(Ak.thread_type)});
        if (Ak.thread_type == 33) {
            aVar.jli.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.jli.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.jli, R.drawable.person_post_line);
        am.setViewTextColor(aVar.jli, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.jli.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.jvy);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes8.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View fEA;
        private View fEB;
        public TextView jli;
        public ReplyLinearLayout jvA;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.jvA = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.jli = (TextView) view.findViewById(R.id.original_post_title);
            this.fEA = view.findViewById(R.id.reply_top_line);
            this.fEB = view.findViewById(R.id.reply_bottom_line);
            this.jli.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.jli, R.color.cp_bg_line_e);
            am.setViewTextColor(this.jli, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fEA, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fEB, R.color.cp_bg_line_c);
        }
    }
}
