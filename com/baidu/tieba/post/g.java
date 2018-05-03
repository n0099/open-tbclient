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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private BdUniqueId aBK;
    private TbPageContext<BaseFragmentActivity> cMX;
    private PersonPostModel fJr;
    private PersonPostModel.a fRZ;
    private final PersonPostModel.a fSa = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.fJr = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.fJr.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.fJr != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.fJr.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.fRZ != null) {
                g.this.fRZ.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0203a fSb = new a.InterfaceC0203a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0203a
        public void bp(View view2) {
            String[] strArr;
            int id = view2.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) g.this.cMX.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) g.this.cMX.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view2.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.cMX.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.cMX.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private String mPortraitUrl;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.cMX = tbPageContext;
        this.mUid = str;
        this.aBK = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.fRZ = aVar;
    }

    public void lx(boolean z) {
        if (this.fJr == null) {
            this.fJr = new PersonPostModel(this.cMX, this.aBK, null, true, PersonPostModel.FROM_PERSON_POST);
            this.fJr.setUniqueId(this.aBK);
        }
        this.fJr.fetchPost(this.cMX, this.fSa, z, this.mUid, false, true, false);
    }

    public void arg() {
        if (this.fJr != null) {
            this.fJr.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJr == null || this.fJr.postList == null) {
            return 0;
        }
        return this.fJr.postList.size();
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.person_post_item_reply, viewGroup, false);
            aVar = new a(view2, this.cMX);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        if (i == 0) {
            aVar.fKM.setVisibility(0);
        } else {
            aVar.fKM.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view2;
    }

    public PersonPostModel.PostInfoList rv(int i) {
        return (PersonPostModel.PostInfoList) this.fJr.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList rv = rv(i);
        if (this.mPortraitUrl == null) {
            this.mPortraitUrl = rv.user_portrait;
        }
        aVar.a(rv, false, this.mPortraitUrl);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = rv.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (rv.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!rv.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = rv.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(rv.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(rv.thread_id), String.valueOf(rv.content[i2].post_id), String.valueOf(rv.content[i2].post_type), an.s(rv.content[i2].create_time * 1000), String.valueOf(rv.thread_type)});
            }
        }
        aVar.fSd.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(rv.title).find()) {
            aVar.fKF.setText(rv.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.fKF.setText(rv.title);
        }
        if (rv.originalThreadInfo != null && !StringUtils.isNull(rv.originalThreadInfo.showText)) {
            aVar.fKF.setText("分享：" + rv.originalThreadInfo.showText);
        }
        aVar.fKF.setTag(new String[]{String.valueOf(rv.thread_id), null, null, String.valueOf(rv.thread_type)});
        if (rv.thread_type == 33) {
            aVar.fKF.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.fKF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ak.i(aVar.fKF, d.f.person_post_line);
        ak.c(aVar.fKF, d.C0126d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.fKF.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.fSb);
        aVar.dv(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View bYn;
        private View cpn;
        public TextView fKF;
        public ReplyLinearLayout fSd;

        public a(View view2, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view2, tbPageContext);
            this.fSd = (ReplyLinearLayout) view2.findViewById(d.g.content_container);
            this.fKF = (TextView) view2.findViewById(d.g.original_post_title);
            this.cpn = view2.findViewById(d.g.reply_top_line);
            this.bYn = view2.findViewById(d.g.reply_bottom_line);
            this.fKF.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void dv(int i) {
            super.dv(i);
            ak.i(this.fKF, d.C0126d.cp_bg_line_e);
            ak.c(this.fKF, d.C0126d.cp_cont_b, 1);
            ak.i(this.cpn, d.C0126d.cp_bg_line_b);
            ak.i(this.bYn, d.C0126d.cp_bg_line_b);
        }
    }
}
