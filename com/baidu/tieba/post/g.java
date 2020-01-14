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
/* loaded from: classes9.dex */
public class g extends BaseAdapter {
    private BdUniqueId Mm;
    private TbPageContext<BaseFragmentActivity> gbi;
    private String jlV;
    private PersonPostModel jni;
    private PersonPostModel.a jzd;
    private final PersonPostModel.a jze = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.jni = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.jni.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.jni != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.jni.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.jzd != null) {
                g.this.jzd.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0583a jzf = new a.InterfaceC0583a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0583a
        public void cL(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.gbi.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.gbi.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.gbi.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.gbi.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.gbi = tbPageContext;
        this.mUid = str;
        this.Mm = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.jzd = aVar;
    }

    public void rQ(boolean z) {
        if (this.jni == null) {
            this.jni = new PersonPostModel(this.gbi, this.Mm, null, true, PersonPostModel.FROM_PERSON_POST);
            this.jni.setUniqueId(this.Mm);
        }
        this.jni.fetchPost(this.gbi, this.jze, z, this.mUid, false, true, false, null);
    }

    public void bER() {
        if (this.jni != null) {
            this.jni.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jni == null || this.jni.postList == null) {
            return 0;
        }
        return this.jni.postList.size();
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
            aVar = new a(view, this.gbi);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.joX.setVisibility(0);
        } else {
            aVar.joX.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Ap(int i) {
        return (PersonPostModel.PostInfoList) this.jni.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Ap = Ap(i);
        if (this.jlV == null) {
            this.jlV = Ap.user_portrait;
        }
        aVar.a(Ap, false, this.jlV);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Ap.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Ap.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Ap.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Ap.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Ap.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Ap.thread_id), String.valueOf(Ap.content[i2].post_id), String.valueOf(Ap.content[i2].post_type), aq.getFormatTime(Ap.content[i2].create_time * 1000), String.valueOf(Ap.thread_type)});
            }
        }
        aVar.jzh.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Ap.title).find()) {
            aVar.joQ.setText(Ap.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.joQ.setText(Ap.title);
        }
        if (Ap.originalThreadInfo != null && !StringUtils.isNull(Ap.originalThreadInfo.showText)) {
            aVar.joQ.setText("分享：" + Ap.originalThreadInfo.showText);
        }
        aVar.joQ.setTag(new String[]{String.valueOf(Ap.thread_id), null, null, String.valueOf(Ap.thread_type)});
        if (Ap.thread_type == 33) {
            aVar.joQ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.joQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.joQ, R.drawable.person_post_line);
        am.setViewTextColor(aVar.joQ, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.joQ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.jzf);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes9.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View fHK;
        private View fHL;
        public TextView joQ;
        public ReplyLinearLayout jzh;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.jzh = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.joQ = (TextView) view.findViewById(R.id.original_post_title);
            this.fHK = view.findViewById(R.id.reply_top_line);
            this.fHL = view.findViewById(R.id.reply_bottom_line);
            this.joQ.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.joQ, R.color.cp_bg_line_e);
            am.setViewTextColor(this.joQ, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fHK, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHL, R.color.cp_bg_line_c);
        }
    }
}
