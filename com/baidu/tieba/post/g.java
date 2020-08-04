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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class g extends BaseAdapter {
    private BdUniqueId agB;
    private TbPageContext<BaseFragmentActivity> huq;
    private String kUS;
    private PersonPostModel kWc;
    private PersonPostModel.a lgh;
    private final PersonPostModel.a lgi = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.kWc = personPostModel;
                Iterator<q> it = g.this.kWc.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.kWc != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.kWc.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.lgh != null) {
                g.this.lgh.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0732a lgj = new a.InterfaceC0732a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0732a
        public void dc(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.huq.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.huq.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.huq.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.huq.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.huq = tbPageContext;
        this.mUid = str;
        this.agB = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.lgh = aVar;
    }

    public void uu(boolean z) {
        if (this.kWc == null) {
            this.kWc = new PersonPostModel(this.huq, this.agB, null, true, PersonPostModel.FROM_PERSON_POST);
            this.kWc.setUniqueId(this.agB);
        }
        this.kWc.fetchPost(this.huq, this.lgi, z, this.mUid, false, true, false, null);
    }

    public void ceq() {
        if (this.kWc != null) {
            this.kWc.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kWc == null || this.kWc.postList == null) {
            return 0;
        }
        return this.kWc.postList.size();
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
            aVar = new a(view, this.huq);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.kXS.setVisibility(0);
        } else {
            aVar.kXS.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Dr(int i) {
        return (PersonPostModel.PostInfoList) this.kWc.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Dr = Dr(i);
        if (this.kUS == null) {
            this.kUS = Dr.user_portrait;
        }
        aVar.a(Dr, false, this.kUS);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Dr.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Dr.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Dr.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Dr.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Dr.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Dr.thread_id), String.valueOf(Dr.content[i2].post_id), String.valueOf(Dr.content[i2].post_type), as.getFormatTime(Dr.content[i2].create_time * 1000), String.valueOf(Dr.thread_type)});
            }
        }
        aVar.lgl.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Dr.title).find()) {
            aVar.kXL.setText(Dr.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.kXL.setText(Dr.title);
        }
        if (Dr.originalThreadInfo != null && !StringUtils.isNull(Dr.originalThreadInfo.showText)) {
            aVar.kXL.setText("分享：" + Dr.originalThreadInfo.showText);
        }
        aVar.kXL.setTag(new String[]{String.valueOf(Dr.thread_id), null, null, String.valueOf(Dr.thread_type)});
        if (Dr.thread_type == 33) {
            aVar.kXL.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.kXL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ao.setBackgroundResource(aVar.kXL, R.drawable.person_post_line);
        ao.setViewTextColor(aVar.kXL, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.kXL.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.lgj);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes18.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View gXm;
        private View gXn;
        public TextView kXL;
        public ReplyLinearLayout lgl;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.lgl = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.kXL = (TextView) view.findViewById(R.id.original_post_title);
            this.gXm = view.findViewById(R.id.reply_top_line);
            this.gXn = view.findViewById(R.id.reply_bottom_line);
            this.kXL.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ao.setBackgroundResource(this.kXL, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.kXL, R.color.cp_cont_b, 1);
            ao.setBackgroundResource(this.gXm, R.color.cp_bg_line_c);
            ao.setBackgroundResource(this.gXn, R.color.cp_bg_line_c);
        }
    }
}
