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
import com.baidu.adp.widget.ListView.o;
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
    private BdUniqueId afZ;
    private TbPageContext<BaseFragmentActivity> hct;
    private PersonPostModel.a kES;
    private final PersonPostModel.a kET = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.ktf = personPostModel;
                Iterator<o> it = g.this.ktf.postList.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.ktf != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.ktf.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.kES != null) {
                g.this.kES.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0706a kEU = new a.InterfaceC0706a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0706a
        public void cV(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.hct.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.hct.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.hct.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.hct.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private String krT;
    private PersonPostModel ktf;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.hct = tbPageContext;
        this.mUid = str;
        this.afZ = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.kES = aVar;
    }

    public void tB(boolean z) {
        if (this.ktf == null) {
            this.ktf = new PersonPostModel(this.hct, this.afZ, null, true, PersonPostModel.FROM_PERSON_POST);
            this.ktf.setUniqueId(this.afZ);
        }
        this.ktf.fetchPost(this.hct, this.kET, z, this.mUid, false, true, false, null);
    }

    public void bXG() {
        if (this.ktf != null) {
            this.ktf.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ktf == null || this.ktf.postList == null) {
            return 0;
        }
        return this.ktf.postList.size();
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
            aVar = new a(view, this.hct);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.kuX.setVisibility(0);
        } else {
            aVar.kuX.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList BT(int i) {
        return (PersonPostModel.PostInfoList) this.ktf.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList BT = BT(i);
        if (this.krT == null) {
            this.krT = BT.user_portrait;
        }
        aVar.a(BT, false, this.krT);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = BT.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (BT.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!BT.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = BT.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(BT.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(BT.thread_id), String.valueOf(BT.content[i2].post_id), String.valueOf(BT.content[i2].post_type), aq.getFormatTime(BT.content[i2].create_time * 1000), String.valueOf(BT.thread_type)});
            }
        }
        aVar.kEW.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(BT.title).find()) {
            aVar.kuQ.setText(BT.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.kuQ.setText(BT.title);
        }
        if (BT.originalThreadInfo != null && !StringUtils.isNull(BT.originalThreadInfo.showText)) {
            aVar.kuQ.setText("分享：" + BT.originalThreadInfo.showText);
        }
        aVar.kuQ.setTag(new String[]{String.valueOf(BT.thread_id), null, null, String.valueOf(BT.thread_type)});
        if (BT.thread_type == 33) {
            aVar.kuQ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.kuQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.kuQ, R.drawable.person_post_line);
        am.setViewTextColor(aVar.kuQ, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.kuQ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.kEU);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes11.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View gER;
        private View gES;
        public ReplyLinearLayout kEW;
        public TextView kuQ;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.kEW = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.kuQ = (TextView) view.findViewById(R.id.original_post_title);
            this.gER = view.findViewById(R.id.reply_top_line);
            this.gES = view.findViewById(R.id.reply_bottom_line);
            this.kuQ.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.kuQ, R.color.cp_bg_line_e);
            am.setViewTextColor(this.kuQ, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.gER, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gES, R.color.cp_bg_line_c);
        }
    }
}
