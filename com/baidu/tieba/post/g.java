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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class g extends BaseAdapter {
    private BdUniqueId agK;
    private TbPageContext<BaseFragmentActivity> hoE;
    private String kLQ;
    private PersonPostModel kNc;
    private PersonPostModel.a kYO;
    private final PersonPostModel.a kYP = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.kNc = personPostModel;
                Iterator<q> it = g.this.kNc.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.kNc != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.kNc.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.kYO != null) {
                g.this.kYO.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0722a kYQ = new a.InterfaceC0722a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0722a
        public void cW(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.hoE.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.hoE.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.hoE.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.hoE.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.hoE = tbPageContext;
        this.mUid = str;
        this.agK = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.kYO = aVar;
    }

    public void tQ(boolean z) {
        if (this.kNc == null) {
            this.kNc = new PersonPostModel(this.hoE, this.agK, null, true, PersonPostModel.FROM_PERSON_POST);
            this.kNc.setUniqueId(this.agK);
        }
        this.kNc.fetchPost(this.hoE, this.kYP, z, this.mUid, false, true, false, null);
    }

    public void caS() {
        if (this.kNc != null) {
            this.kNc.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kNc == null || this.kNc.postList == null) {
            return 0;
        }
        return this.kNc.postList.size();
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
            aVar = new a(view, this.hoE);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.kOU.setVisibility(0);
        } else {
            aVar.kOU.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList CV(int i) {
        return (PersonPostModel.PostInfoList) this.kNc.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList CV = CV(i);
        if (this.kLQ == null) {
            this.kLQ = CV.user_portrait;
        }
        aVar.a(CV, false, this.kLQ);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = CV.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (CV.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!CV.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = CV.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(CV.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(CV.thread_id), String.valueOf(CV.content[i2].post_id), String.valueOf(CV.content[i2].post_type), ar.getFormatTime(CV.content[i2].create_time * 1000), String.valueOf(CV.thread_type)});
            }
        }
        aVar.kYS.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(CV.title).find()) {
            aVar.kON.setText(CV.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.kON.setText(CV.title);
        }
        if (CV.originalThreadInfo != null && !StringUtils.isNull(CV.originalThreadInfo.showText)) {
            aVar.kON.setText("分享：" + CV.originalThreadInfo.showText);
        }
        aVar.kON.setTag(new String[]{String.valueOf(CV.thread_id), null, null, String.valueOf(CV.thread_type)});
        if (CV.thread_type == 33) {
            aVar.kON.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.kON.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        an.setBackgroundResource(aVar.kON, R.drawable.person_post_line);
        an.setViewTextColor(aVar.kON, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.kON.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.kYQ);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes11.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View gRH;
        private View gRI;
        public TextView kON;
        public ReplyLinearLayout kYS;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.kYS = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.kON = (TextView) view.findViewById(R.id.original_post_title);
            this.gRH = view.findViewById(R.id.reply_top_line);
            this.gRI = view.findViewById(R.id.reply_bottom_line);
            this.kON.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            an.setBackgroundResource(this.kON, R.color.cp_bg_line_e);
            an.setViewTextColor(this.kON, R.color.cp_cont_b, 1);
            an.setBackgroundResource(this.gRH, R.color.cp_bg_line_c);
            an.setBackgroundResource(this.gRI, R.color.cp_bg_line_c);
        }
    }
}
