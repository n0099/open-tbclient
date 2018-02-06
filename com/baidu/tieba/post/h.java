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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private BdUniqueId brv;
    private TbPageContext<BaseFragmentActivity> duu;
    private String gnP;
    private PersonPostModel goP;
    private PersonPostModel.a gxl;
    private final PersonPostModel.a gxm = new PersonPostModel.a() { // from class: com.baidu.tieba.post.h.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                h.this.goP = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.i> it = h.this.goP.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.i next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (h.this.goP != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        h.this.goP.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (h.this.gxl != null) {
                h.this.gxl.b(personPostModel, z);
            }
            h.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0220a gxn = new a.InterfaceC0220a() { // from class: com.baidu.tieba.post.h.2
        @Override // com.baidu.tieba.post.a.InterfaceC0220a
        public void cJ(View view) {
            String[] strArr;
            boolean z;
            int id = view.getId();
            if (id == d.g.portrait) {
                ((BaseFragmentActivity) h.this.duu.getOrignalPage()).finish();
            } else if (id == d.g.username) {
                ((BaseFragmentActivity) h.this.duu.getOrignalPage()).finish();
            } else if ((id == d.g.item_header || id == d.g.original_post_title || id == d.g.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if (strArr.length < 4 || strArr[3] == null || com.baidu.adp.lib.g.b.h(strArr[3], 0) != 33) {
                    z = false;
                } else if ("0".equals(strArr[2]) || strArr[1] == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(h.this.duu.getPageActivity(), strArr[0]).xD()));
                    z = true;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveCommentActivityConfig(h.this.duu.getPageActivity()).createPhotoLiveCommentActivityConfig(strArr[0], strArr[1], false)));
                    z = true;
                }
                if (!z) {
                    if ("0".equals(strArr[2]) || strArr[1] == null) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.duu.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                        createNormalCfg.setStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                        return;
                    }
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(h.this.duu.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                    createSubPbActivityConfig.setKeyPageStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                }
            }
        }
    };
    private final String mUid;

    public h(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.duu = tbPageContext;
        this.mUid = str;
        this.brv = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.gxl = aVar;
    }

    public void lS(boolean z) {
        if (this.goP == null) {
            this.goP = new PersonPostModel(this.duu, this.brv, null, true, PersonPostModel.FROM_PERSON_POST);
            this.goP.setUniqueId(this.brv);
        }
        this.goP.fetchPost(this.duu, this.gxm, z, this.mUid, false, true, false);
    }

    public void awP() {
        if (this.goP != null) {
            this.goP.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.goP == null || this.goP.postList == null) {
            return 0;
        }
        return this.goP.postList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.duu);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gqj.setVisibility(0);
        } else {
            aVar.gqj.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList tX(int i) {
        return (PersonPostModel.PostInfoList) this.goP.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList tX = tX(i);
        if (this.gnP == null) {
            this.gnP = tX.user_portrait;
        }
        aVar.a(tX, false, this.gnP);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = tX.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (tX.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!tX.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = tX.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(tX.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(tX.thread_id), String.valueOf(tX.content[i2].post_id), String.valueOf(tX.content[i2].post_type), am.z(tX.content[i2].create_time * 1000), String.valueOf(tX.thread_type)});
            }
        }
        aVar.gxp.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(tX.title).find()) {
            aVar.gqc.setText(tX.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.gqc.setText(tX.title);
        }
        if (tX.originalThreadInfo != null && !StringUtils.isNull(tX.originalThreadInfo.showText)) {
            aVar.gqc.setText("分享：" + tX.originalThreadInfo.showText);
        }
        aVar.gqc.setTag(new String[]{String.valueOf(tX.thread_id), null, null, String.valueOf(tX.thread_type)});
        if (tX.thread_type == 33) {
            aVar.gqc.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.gqc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        aj.s(aVar.gqc, d.f.person_post_line);
        aj.e(aVar.gqc, d.C0140d.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(d.e.ds20);
        aVar.gqc.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.gxn);
        aVar.gx(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View cIs;
        private View cXJ;
        public TextView gqc;
        public ReplyLinearLayout gxp;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.gxp = (ReplyLinearLayout) view.findViewById(d.g.content_container);
            this.gqc = (TextView) view.findViewById(d.g.original_post_title);
            this.cXJ = view.findViewById(d.g.reply_top_line);
            this.cIs = view.findViewById(d.g.reply_bottom_line);
            this.gqc.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void gx(int i) {
            super.gx(i);
            aj.s(this.gqc, d.C0140d.cp_bg_line_e);
            aj.e(this.gqc, d.C0140d.cp_cont_b, 1);
            aj.s(this.cXJ, d.C0140d.cp_bg_line_b);
            aj.s(this.cIs, d.C0140d.cp_bg_line_b);
        }
    }
}
