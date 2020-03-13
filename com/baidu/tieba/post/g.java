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
    private BdUniqueId MO;
    private TbPageContext<BaseFragmentActivity> gdy;
    private PersonPostModel.a jAh;
    private final PersonPostModel.a jAi = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.jop = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.jop.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.jop != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.jop.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.jAh != null) {
                g.this.jAh.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0591a jAj = new a.InterfaceC0591a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0591a
        public void cM(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.gdy.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.gdy.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.gdy.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.gdy.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private String jnd;
    private PersonPostModel jop;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.gdy = tbPageContext;
        this.mUid = str;
        this.MO = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.jAh = aVar;
    }

    public void rT(boolean z) {
        if (this.jop == null) {
            this.jop = new PersonPostModel(this.gdy, this.MO, null, true, PersonPostModel.FROM_PERSON_POST);
            this.jop.setUniqueId(this.MO);
        }
        this.jop.fetchPost(this.gdy, this.jAi, z, this.mUid, false, true, false, null);
    }

    public void bGw() {
        if (this.jop != null) {
            this.jop.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jop == null || this.jop.postList == null) {
            return 0;
        }
        return this.jop.postList.size();
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
            aVar = new a(view, this.gdy);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.jqh.setVisibility(0);
        } else {
            aVar.jqh.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Az(int i) {
        return (PersonPostModel.PostInfoList) this.jop.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Az = Az(i);
        if (this.jnd == null) {
            this.jnd = Az.user_portrait;
        }
        aVar.a(Az, false, this.jnd);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Az.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Az.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Az.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Az.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Az.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Az.thread_id), String.valueOf(Az.content[i2].post_id), String.valueOf(Az.content[i2].post_type), aq.getFormatTime(Az.content[i2].create_time * 1000), String.valueOf(Az.thread_type)});
            }
        }
        aVar.jAl.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Az.title).find()) {
            aVar.jqa.setText(Az.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.jqa.setText(Az.title);
        }
        if (Az.originalThreadInfo != null && !StringUtils.isNull(Az.originalThreadInfo.showText)) {
            aVar.jqa.setText("分享：" + Az.originalThreadInfo.showText);
        }
        aVar.jqa.setTag(new String[]{String.valueOf(Az.thread_id), null, null, String.valueOf(Az.thread_type)});
        if (Az.thread_type == 33) {
            aVar.jqa.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.jqa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.jqa, R.drawable.person_post_line);
        am.setViewTextColor(aVar.jqa, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.jqa.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.jAj);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes11.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View fKw;
        private View fKx;
        public ReplyLinearLayout jAl;
        public TextView jqa;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.jAl = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.jqa = (TextView) view.findViewById(R.id.original_post_title);
            this.fKw = view.findViewById(R.id.reply_top_line);
            this.fKx = view.findViewById(R.id.reply_bottom_line);
            this.jqa.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.jqa, R.color.cp_bg_line_e);
            am.setViewTextColor(this.jqa, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fKw, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKx, R.color.cp_bg_line_c);
        }
    }
}
