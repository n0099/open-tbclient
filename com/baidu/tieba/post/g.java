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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class g extends BaseAdapter {
    private BdUniqueId aiE;
    private TbPageContext<BaseFragmentActivity> iwW;
    private final String mUid;
    private String mbQ;
    private PersonPostModel mda;
    private PersonPostModel.a mnH;
    private final PersonPostModel.a mnI = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.mda = personPostModel;
                Iterator<q> it = g.this.mda.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.mda != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.mda.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.mnH != null) {
                g.this.mnH.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0830a mnJ = new a.InterfaceC0830a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0830a
        public void dF(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.iwW.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.iwW.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.iwW.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.iwW.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.iwW = tbPageContext;
        this.mUid = str;
        this.aiE = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.mnH = aVar;
    }

    public void wA(boolean z) {
        if (this.mda == null) {
            this.mda = new PersonPostModel(this.iwW, this.aiE, null, true, PersonPostModel.FROM_PERSON_POST);
            this.mda.setUniqueId(this.aiE);
        }
        this.mda.fetchPost(this.iwW, this.mnI, z, this.mUid, false, true, false, null);
    }

    public void cAQ() {
        if (this.mda != null) {
            this.mda.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mda == null || this.mda.postList == null) {
            return 0;
        }
        return this.mda.postList.size();
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
            aVar = new a(view, this.iwW);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.mfi.setVisibility(0);
        } else {
            aVar.mfi.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList HX(int i) {
        return (PersonPostModel.PostInfoList) this.mda.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList HX = HX(i);
        if (this.mbQ == null) {
            this.mbQ = HX.user_portrait;
        }
        aVar.a(HX, false, this.mbQ);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = HX.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (HX.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!HX.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = HX.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(HX.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(HX.thread_id), String.valueOf(HX.content[i2].post_id), String.valueOf(HX.content[i2].post_type), au.getFormatTime(HX.content[i2].create_time * 1000), String.valueOf(HX.thread_type)});
            }
        }
        aVar.mnL.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(HX.title).find()) {
            aVar.mfb.setText(HX.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.mfb.setText(HX.title);
        }
        if (HX.originalThreadInfo != null && !StringUtils.isNull(HX.originalThreadInfo.showText)) {
            aVar.mfb.setText("分享：" + HX.originalThreadInfo.showText);
        }
        aVar.mfb.setTag(new String[]{String.valueOf(HX.thread_id), null, null, String.valueOf(HX.thread_type)});
        if (HX.thread_type == 33) {
            aVar.mfb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.mfb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ap.setBackgroundResource(aVar.mfb, R.drawable.person_post_line);
        ap.setViewTextColor(aVar.mfb, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.mfb.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.mnJ);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes23.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View hZa;
        private View hZb;
        public TextView mfb;
        public ReplyLinearLayout mnL;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.mnL = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.mfb = (TextView) view.findViewById(R.id.original_post_title);
            this.hZa = view.findViewById(R.id.reply_top_line);
            this.hZb = view.findViewById(R.id.reply_bottom_line);
            this.mfb.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ap.setBackgroundResource(this.mfb, R.color.CAM_X0205);
            ap.setViewTextColor(this.mfb, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.hZa, R.color.CAM_X0204);
            ap.setBackgroundResource(this.hZb, R.color.CAM_X0204);
        }
    }
}
