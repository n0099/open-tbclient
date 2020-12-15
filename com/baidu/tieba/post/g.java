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
/* loaded from: classes24.dex */
public class g extends BaseAdapter {
    private BdUniqueId ajD;
    private TbPageContext<BaseFragmentActivity> iHQ;
    private PersonPostModel.a mBN;
    private final PersonPostModel.a mBO = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.mri = personPostModel;
                Iterator<q> it = g.this.mri.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.mri != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.mri.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.mBN != null) {
                g.this.mBN.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0846a mBP = new a.InterfaceC0846a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0846a
        public void dQ(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.iHQ.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.iHQ.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.iHQ.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.iHQ.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;
    private String mpY;
    private PersonPostModel mri;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.iHQ = tbPageContext;
        this.mUid = str;
        this.ajD = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.mBN = aVar;
    }

    public void xe(boolean z) {
        if (this.mri == null) {
            this.mri = new PersonPostModel(this.iHQ, this.ajD, null, true, PersonPostModel.FROM_PERSON_POST);
            this.mri.setUniqueId(this.ajD);
        }
        this.mri.fetchPost(this.iHQ, this.mBO, z, this.mUid, false, true, false, null);
    }

    public void cFh() {
        if (this.mri != null) {
            this.mri.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mri == null || this.mri.postList == null) {
            return 0;
        }
        return this.mri.postList.size();
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
            aVar = new a(view, this.iHQ);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.mtq.setVisibility(0);
        } else {
            aVar.mtq.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList IO(int i) {
        return (PersonPostModel.PostInfoList) this.mri.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList IO = IO(i);
        if (this.mpY == null) {
            this.mpY = IO.user_portrait;
        }
        aVar.a(IO, false, this.mpY);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = IO.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (IO.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!IO.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = IO.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(IO.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(IO.thread_id), String.valueOf(IO.content[i2].post_id), String.valueOf(IO.content[i2].post_type), au.getFormatTime(IO.content[i2].create_time * 1000), String.valueOf(IO.thread_type)});
            }
        }
        aVar.mBR.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(IO.title).find()) {
            aVar.mtj.setText(IO.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.mtj.setText(IO.title);
        }
        if (IO.originalThreadInfo != null && !StringUtils.isNull(IO.originalThreadInfo.showText)) {
            aVar.mtj.setText("分享：" + IO.originalThreadInfo.showText);
        }
        aVar.mtj.setTag(new String[]{String.valueOf(IO.thread_id), null, null, String.valueOf(IO.thread_type)});
        if (IO.thread_type == 33) {
            aVar.mtj.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.mtj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ap.setBackgroundResource(aVar.mtj, R.drawable.person_post_line);
        ap.setViewTextColor(aVar.mtj, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.mtj.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.mBP);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes24.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View ijZ;
        private View ika;
        public ReplyLinearLayout mBR;
        public TextView mtj;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.mBR = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.mtj = (TextView) view.findViewById(R.id.original_post_title);
            this.ijZ = view.findViewById(R.id.reply_top_line);
            this.ika = view.findViewById(R.id.reply_bottom_line);
            this.mtj.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ap.setBackgroundResource(this.mtj, R.color.CAM_X0205);
            ap.setViewTextColor(this.mtj, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.ijZ, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ika, R.color.CAM_X0204);
        }
    }
}
