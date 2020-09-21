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
/* loaded from: classes23.dex */
public class g extends BaseAdapter {
    private BdUniqueId aih;
    private TbPageContext<BaseFragmentActivity> hON;
    private PersonPostModel.a lFC;
    private final PersonPostModel.a lFD = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.lvb = personPostModel;
                Iterator<q> it = g.this.lvb.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.lvb != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.lvb.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.lFC != null) {
                g.this.lFC.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0780a lFE = new a.InterfaceC0780a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0780a
        /* renamed from: do */
        public void mo42do(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.hON.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.hON.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.hON.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.hON.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private String ltR;
    private PersonPostModel lvb;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.hON = tbPageContext;
        this.mUid = str;
        this.aih = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.lFC = aVar;
    }

    public void vq(boolean z) {
        if (this.lvb == null) {
            this.lvb = new PersonPostModel(this.hON, this.aih, null, true, PersonPostModel.FROM_PERSON_POST);
            this.lvb.setUniqueId(this.aih);
        }
        this.lvb.fetchPost(this.hON, this.lFD, z, this.mUid, false, true, false, null);
    }

    public void csi() {
        if (this.lvb != null) {
            this.lvb.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lvb == null || this.lvb.postList == null) {
            return 0;
        }
        return this.lvb.postList.size();
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
            aVar = new a(view, this.hON);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.lxe.setVisibility(0);
        } else {
            aVar.lxe.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Gn(int i) {
        return (PersonPostModel.PostInfoList) this.lvb.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Gn = Gn(i);
        if (this.ltR == null) {
            this.ltR = Gn.user_portrait;
        }
        aVar.a(Gn, false, this.ltR);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Gn.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Gn.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Gn.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Gn.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Gn.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Gn.thread_id), String.valueOf(Gn.content[i2].post_id), String.valueOf(Gn.content[i2].post_type), at.getFormatTime(Gn.content[i2].create_time * 1000), String.valueOf(Gn.thread_type)});
            }
        }
        aVar.lFG.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Gn.title).find()) {
            aVar.lwX.setText(Gn.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.lwX.setText(Gn.title);
        }
        if (Gn.originalThreadInfo != null && !StringUtils.isNull(Gn.originalThreadInfo.showText)) {
            aVar.lwX.setText("分享：" + Gn.originalThreadInfo.showText);
        }
        aVar.lwX.setTag(new String[]{String.valueOf(Gn.thread_id), null, null, String.valueOf(Gn.thread_type)});
        if (Gn.thread_type == 33) {
            aVar.lwX.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.lwX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ap.setBackgroundResource(aVar.lwX, R.drawable.person_post_line);
        ap.setViewTextColor(aVar.lwX, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.lwX.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.lFE);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes23.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View hrm;
        private View hrn;
        public ReplyLinearLayout lFG;
        public TextView lwX;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.lFG = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.lwX = (TextView) view.findViewById(R.id.original_post_title);
            this.hrm = view.findViewById(R.id.reply_top_line);
            this.hrn = view.findViewById(R.id.reply_bottom_line);
            this.lwX.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ap.setBackgroundResource(this.lwX, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lwX, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hrm, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hrn, R.color.cp_bg_line_c);
        }
    }
}
