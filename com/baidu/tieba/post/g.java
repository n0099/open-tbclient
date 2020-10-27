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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes24.dex */
public class g extends BaseAdapter {
    private BdUniqueId aiz;
    private TbPageContext<BaseFragmentActivity> iqk;
    private String lVz;
    private PersonPostModel lWJ;
    private final String mUid;
    private PersonPostModel.a mhp;
    private final PersonPostModel.a mhq = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.lWJ = personPostModel;
                Iterator<q> it = g.this.lWJ.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.lWJ != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.lWJ.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.mhp != null) {
                g.this.mhp.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0813a mhr = new a.InterfaceC0813a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0813a
        public void dw(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.iqk.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.iqk.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.iqk.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.iqk.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.iqk = tbPageContext;
        this.mUid = str;
        this.aiz = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.mhp = aVar;
    }

    public void wo(boolean z) {
        if (this.lWJ == null) {
            this.lWJ = new PersonPostModel(this.iqk, this.aiz, null, true, PersonPostModel.FROM_PERSON_POST);
            this.lWJ.setUniqueId(this.aiz);
        }
        this.lWJ.fetchPost(this.iqk, this.mhq, z, this.mUid, false, true, false, null);
    }

    public void cyM() {
        if (this.lWJ != null) {
            this.lWJ.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lWJ == null || this.lWJ.postList == null) {
            return 0;
        }
        return this.lWJ.postList.size();
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
            aVar = new a(view, this.iqk);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.lYQ.setVisibility(0);
        } else {
            aVar.lYQ.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Hm(int i) {
        return (PersonPostModel.PostInfoList) this.lWJ.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Hm = Hm(i);
        if (this.lVz == null) {
            this.lVz = Hm.user_portrait;
        }
        aVar.a(Hm, false, this.lVz);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Hm.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Hm.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Hm.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Hm.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Hm.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Hm.thread_id), String.valueOf(Hm.content[i2].post_id), String.valueOf(Hm.content[i2].post_type), at.getFormatTime(Hm.content[i2].create_time * 1000), String.valueOf(Hm.thread_type)});
            }
        }
        aVar.mht.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Hm.title).find()) {
            aVar.lYJ.setText(Hm.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.lYJ.setText(Hm.title);
        }
        if (Hm.originalThreadInfo != null && !StringUtils.isNull(Hm.originalThreadInfo.showText)) {
            aVar.lYJ.setText("分享：" + Hm.originalThreadInfo.showText);
        }
        aVar.lYJ.setTag(new String[]{String.valueOf(Hm.thread_id), null, null, String.valueOf(Hm.thread_type)});
        if (Hm.thread_type == 33) {
            aVar.lYJ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.lYJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ap.setBackgroundResource(aVar.lYJ, R.drawable.person_post_line);
        ap.setViewTextColor(aVar.lYJ, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.lYJ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.mhr);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes24.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View hSD;
        private View hSE;
        public TextView lYJ;
        public ReplyLinearLayout mht;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.mht = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.lYJ = (TextView) view.findViewById(R.id.original_post_title);
            this.hSD = view.findViewById(R.id.reply_top_line);
            this.hSE = view.findViewById(R.id.reply_bottom_line);
            this.lYJ.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ap.setBackgroundResource(this.lYJ, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lYJ, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hSD, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hSE, R.color.cp_bg_line_c);
        }
    }
}
