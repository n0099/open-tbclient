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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {
    private BdUniqueId aqw;
    private TbPageContext<BaseFragmentActivity> cXW;
    private String fZj;
    private PersonPostModel gal;
    private PersonPostModel.a giV;
    private final PersonPostModel.a giW = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.gal = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.h> it = g.this.gal.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.gal != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.gal.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.giV != null) {
                g.this.giV.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0220a giX = new a.InterfaceC0220a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0220a
        public void bw(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == f.g.portrait) {
                ((BaseFragmentActivity) g.this.cXW.getOrignalPage()).finish();
            } else if (id == f.g.username) {
                ((BaseFragmentActivity) g.this.cXW.getOrignalPage()).finish();
            } else if ((id == f.g.item_header || id == f.g.original_post_title || id == f.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.cXW.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.cXW.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.cXW = tbPageContext;
        this.mUid = str;
        this.aqw = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.giV = aVar;
    }

    public void lz(boolean z) {
        if (this.gal == null) {
            this.gal = new PersonPostModel(this.cXW, this.aqw, null, true, PersonPostModel.FROM_PERSON_POST);
            this.gal.setUniqueId(this.aqw);
        }
        this.gal.fetchPost(this.cXW, this.giW, z, this.mUid, false, true, false);
    }

    public void awr() {
        if (this.gal != null) {
            this.gal.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gal == null || this.gal.postList == null) {
            return 0;
        }
        return this.gal.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.cXW);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gbv.setVisibility(0);
        } else {
            aVar.gbv.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList rM(int i) {
        return (PersonPostModel.PostInfoList) this.gal.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList rM = rM(i);
        if (this.fZj == null) {
            this.fZj = rM.user_portrait;
        }
        aVar.a(rM, false, this.fZj);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = rM.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (rM.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!rM.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = rM.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(rM.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(rM.thread_id), String.valueOf(rM.content[i2].post_id), String.valueOf(rM.content[i2].post_type), ap.w(rM.content[i2].create_time * 1000), String.valueOf(rM.thread_type)});
            }
        }
        aVar.giZ.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(rM.title).find()) {
            aVar.gbo.setText(rM.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gbo.setText(rM.title);
        }
        if (rM.originalThreadInfo != null && !StringUtils.isNull(rM.originalThreadInfo.showText)) {
            aVar.gbo.setText("分享：" + rM.originalThreadInfo.showText);
        }
        aVar.gbo.setTag(new String[]{String.valueOf(rM.thread_id), null, null, String.valueOf(rM.thread_type)});
        if (rM.thread_type == 33) {
            aVar.gbo.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gbo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.i(aVar.gbo, f.C0146f.person_post_line);
        am.c(aVar.gbo, f.d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(f.e.ds20);
        aVar.gbo.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.giX);
        aVar.dB(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View clf;
        private View czu;
        public TextView gbo;
        public ReplyLinearLayout giZ;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.giZ = (ReplyLinearLayout) view.findViewById(f.g.content_container);
            this.gbo = (TextView) view.findViewById(f.g.original_post_title);
            this.czu = view.findViewById(f.g.reply_top_line);
            this.clf = view.findViewById(f.g.reply_bottom_line);
            this.gbo.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void dB(int i) {
            super.dB(i);
            am.i(this.gbo, f.d.cp_bg_line_e);
            am.c(this.gbo, f.d.cp_cont_b, 1);
            am.i(this.czu, f.d.cp_bg_line_b);
            am.i(this.clf, f.d.cp_bg_line_b);
        }
    }
}
