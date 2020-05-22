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
    private TbPageContext<BaseFragmentActivity> hci;
    private PersonPostModel.a kDK;
    private final PersonPostModel.a kDL = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.krZ = personPostModel;
                Iterator<o> it = g.this.krZ.postList.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.krZ != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.krZ.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.kDK != null) {
                g.this.kDK.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0705a kDM = new a.InterfaceC0705a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0705a
        public void cV(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.hci.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.hci.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.hci.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.hci.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private String kqN;
    private PersonPostModel krZ;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.hci = tbPageContext;
        this.mUid = str;
        this.afZ = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.kDK = aVar;
    }

    public void tB(boolean z) {
        if (this.krZ == null) {
            this.krZ = new PersonPostModel(this.hci, this.afZ, null, true, PersonPostModel.FROM_PERSON_POST);
            this.krZ.setUniqueId(this.afZ);
        }
        this.krZ.fetchPost(this.hci, this.kDL, z, this.mUid, false, true, false, null);
    }

    public void bXE() {
        if (this.krZ != null) {
            this.krZ.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.krZ == null || this.krZ.postList == null) {
            return 0;
        }
        return this.krZ.postList.size();
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
            aVar = new a(view, this.hci);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.ktR.setVisibility(0);
        } else {
            aVar.ktR.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList BR(int i) {
        return (PersonPostModel.PostInfoList) this.krZ.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList BR = BR(i);
        if (this.kqN == null) {
            this.kqN = BR.user_portrait;
        }
        aVar.a(BR, false, this.kqN);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = BR.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (BR.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!BR.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = BR.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(BR.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(BR.thread_id), String.valueOf(BR.content[i2].post_id), String.valueOf(BR.content[i2].post_type), aq.getFormatTime(BR.content[i2].create_time * 1000), String.valueOf(BR.thread_type)});
            }
        }
        aVar.kDO.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(BR.title).find()) {
            aVar.ktK.setText(BR.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.ktK.setText(BR.title);
        }
        if (BR.originalThreadInfo != null && !StringUtils.isNull(BR.originalThreadInfo.showText)) {
            aVar.ktK.setText("分享：" + BR.originalThreadInfo.showText);
        }
        aVar.ktK.setTag(new String[]{String.valueOf(BR.thread_id), null, null, String.valueOf(BR.thread_type)});
        if (BR.thread_type == 33) {
            aVar.ktK.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.ktK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.ktK, R.drawable.person_post_line);
        am.setViewTextColor(aVar.ktK, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.ktK.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.kDM);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes11.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View gEG;
        private View gEH;
        public ReplyLinearLayout kDO;
        public TextView ktK;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.kDO = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.ktK = (TextView) view.findViewById(R.id.original_post_title);
            this.gEG = view.findViewById(R.id.reply_top_line);
            this.gEH = view.findViewById(R.id.reply_bottom_line);
            this.ktK.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.ktK, R.color.cp_bg_line_e);
            am.setViewTextColor(this.ktK, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.gEG, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEH, R.color.cp_bg_line_c);
        }
    }
}
