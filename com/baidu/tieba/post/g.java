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
/* loaded from: classes11.dex */
public class g extends BaseAdapter {
    private BdUniqueId afD;
    private TbPageContext<BaseFragmentActivity> gNw;
    private String jYU;
    private PersonPostModel kag;
    private PersonPostModel.a klP;
    private final PersonPostModel.a klQ = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.kag = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.kag.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.kag != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.kag.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.klP != null) {
                g.this.klP.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0652a klR = new a.InterfaceC0652a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0652a
        public void cU(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.gNw.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.gNw.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.gNw.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.gNw.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.gNw = tbPageContext;
        this.mUid = str;
        this.afD = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.klP = aVar;
    }

    public void td(boolean z) {
        if (this.kag == null) {
            this.kag = new PersonPostModel(this.gNw, this.afD, null, true, PersonPostModel.FROM_PERSON_POST);
            this.kag.setUniqueId(this.afD);
        }
        this.kag.fetchPost(this.gNw, this.klQ, z, this.mUid, false, true, false, null);
    }

    public void bRi() {
        if (this.kag != null) {
            this.kag.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kag == null || this.kag.postList == null) {
            return 0;
        }
        return this.kag.postList.size();
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
            aVar = new a(view, this.gNw);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.kbZ.setVisibility(0);
        } else {
            aVar.kbZ.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Bh(int i) {
        return (PersonPostModel.PostInfoList) this.kag.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Bh = Bh(i);
        if (this.jYU == null) {
            this.jYU = Bh.user_portrait;
        }
        aVar.a(Bh, false, this.jYU);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Bh.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Bh.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Bh.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Bh.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Bh.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Bh.thread_id), String.valueOf(Bh.content[i2].post_id), String.valueOf(Bh.content[i2].post_type), aq.getFormatTime(Bh.content[i2].create_time * 1000), String.valueOf(Bh.thread_type)});
            }
        }
        aVar.klT.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Bh.title).find()) {
            aVar.kbS.setText(Bh.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.kbS.setText(Bh.title);
        }
        if (Bh.originalThreadInfo != null && !StringUtils.isNull(Bh.originalThreadInfo.showText)) {
            aVar.kbS.setText("分享：" + Bh.originalThreadInfo.showText);
        }
        aVar.kbS.setTag(new String[]{String.valueOf(Bh.thread_id), null, null, String.valueOf(Bh.thread_type)});
        if (Bh.thread_type == 33) {
            aVar.kbS.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.kbS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.kbS, R.drawable.person_post_line);
        am.setViewTextColor(aVar.kbS, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.kbS.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.klR);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes11.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View gpR;
        private View gpS;
        public TextView kbS;
        public ReplyLinearLayout klT;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.klT = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.kbS = (TextView) view.findViewById(R.id.original_post_title);
            this.gpR = view.findViewById(R.id.reply_top_line);
            this.gpS = view.findViewById(R.id.reply_bottom_line);
            this.kbS.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.kbS, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kbS, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.gpR, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpS, R.color.cp_bg_line_c);
        }
    }
}
