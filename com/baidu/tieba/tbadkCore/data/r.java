package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.v;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class r implements u, aj {
    public static final BdUniqueId dHb = BdUniqueId.gen();
    public static final BdUniqueId dHc = BdUniqueId.gen();
    public static final BdUniqueId dHd = BdUniqueId.gen();
    public static final BdUniqueId dHe = BdUniqueId.gen();
    public static final BdUniqueId dHf = BdUniqueId.gen();
    public static final BdUniqueId dHg = BdUniqueId.gen();
    public static final BdUniqueId dHh = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private SmallTailInfo cMf;
    private String dHk;
    private ArrayList<r> dHm;
    private ArrayList<r> dHp;
    private int dHr;
    private com.baidu.tbadk.data.a dHu;
    private com.baidu.tbadk.data.d dHv;
    private h dHx;
    private HashMap<String, MetaData> userMap;
    private int dHi = 0;
    private boolean dHn = false;
    private com.baidu.tbadk.widget.richText.a dHq = null;
    private boolean dHw = false;
    private String id = null;
    private String title = null;
    private int dHj = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<k> cjV = new ArrayList<>();
    private ArrayList<k> ckK = new ArrayList<>();
    private int dHl = 0;
    private int dHo = 0;
    private int Xg = 0;
    private PraiseData praise = new PraiseData();
    private com.baidu.tbadk.core.data.r dHs = new com.baidu.tbadk.core.data.r();
    private c dHt = new c();

    public r() {
        this.dHm = null;
        this.dHp = null;
        this.dHm = new ArrayList<>();
        this.dHp = new ArrayList<>();
    }

    public c aFl() {
        return this.dHt;
    }

    public ArrayList<r> aFm() {
        return this.dHm;
    }

    public void aFn() {
        this.dHl++;
    }

    public void aFo() {
        this.dHl--;
    }

    public void mX(int i) {
        this.dHl = i;
    }

    public ArrayList<r> aFp() {
        return this.dHp;
    }

    public boolean isGiftPost() {
        return this.dHw;
    }

    public void setIsGiftPost(boolean z) {
        this.dHw = z;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int aFq() {
        return this.dHj;
    }

    public void mY(int i) {
        this.dHj = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public com.baidu.tbadk.widget.richText.a aFr() {
        return this.dHq;
    }

    public void b(com.baidu.tbadk.widget.richText.a aVar) {
        this.dHq = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a aFs() {
        return this.dHu;
    }

    public SmallTailInfo aoe() {
        return this.cMf;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.cMf = smallTailInfo;
    }

    public com.baidu.tbadk.data.d aFt() {
        return this.dHv;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        v vVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cx;
        if (this.dHq != null && this.dHq.FA() != null) {
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new s(this, it.next(), bdUniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(n.e.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(n.e.small_icon_height));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            a aVar = new a(TbadkCoreApplication.m411getInst().getApp(), str, str2);
            if (z && (cx = as.cx(n.f.icon_floorhost)) != null) {
                int width = (cx.getWidth() * dimensionPixelSize) / cx.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> FA = this.dHq.FA();
            if (FA != null && FA.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = FA.get(0);
                if (cVar2.FG() != null) {
                    cVar2.eP(sb.length());
                    cVar2.FG().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= FA.size()) {
                        vVar = null;
                        break;
                    } else if (FA.get(i4) == null || FA.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        v FH = FA.get(i4).FH();
                        FA.remove(i4);
                        vVar = FH;
                        break;
                    }
                }
                if (vVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(vVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.eP(sb.length());
                cVar.append(spannableString);
                FA.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap mE;
        if (aVar == null || (mE = aVar.mE()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mE);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(n.e.ds36), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(n.e.ds36));
        return bitmapDrawable;
    }

    public int aFu() {
        return this.dHl;
    }

    public int aFv() {
        return this.dHo;
    }

    public void aQ(Context context) {
        int type;
        int i;
        int i2;
        if (this.cjV != null) {
            int i3 = -1;
            int size = this.ckK.size();
            if (size > 0) {
                try {
                    i3 = this.ckK.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.cjV.size()) {
                k kVar = this.cjV.get(i4);
                if (k.aZ(i5, kVar.getType())) {
                    this.ckK.get(size - 1).b(kVar.aP(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.ckK.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.aP(context));
                        this.ckK.add(kVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void aR(Context context) {
        try {
            if (this.dHq != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dHq.toString());
                clipboardManager.getText();
                return;
            }
            if (this.ckK == null || this.ckK.size() == 0) {
                aQ(context);
            }
            ArrayList<k> arrayList = this.ckK;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.aEY() != null) {
                            sb.append((CharSequence) next.aEY());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(n.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(n.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fg = TbFaceManager.CL().fg(next.getText());
                        if (fg != null) {
                            sb.append("[");
                            sb.append(fg);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ax.isEmpty(next.aEX())) {
                        sb.append("[").append(next.aEX()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.dHj = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                this.dHw = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dHq = TbRichTextView.b(context, subPostList.content, z);
                if (this.dHq != null) {
                    this.dHq.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.dHj = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.dHk = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.dHl = post.sub_post_number.intValue();
                this.dHo = post.add_post_number.intValue();
                this.dHx = new h(post.tpoint_post);
                this.dHq = TbRichTextView.b(context, post.content, true);
                if (this.dHq != null) {
                    this.dHq.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            r rVar = new r();
                            rVar.dHw = subPostList.is_giftpost.intValue() == 1;
                            rVar.setUserMap(this.userMap);
                            rVar.a(subPostList, context);
                            this.dHm.add(rVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            r rVar2 = new r();
                            rVar2.setUserMap(this.userMap);
                            rVar2.a(subPostList2, context);
                            this.dHp.add(rVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.dHt.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.dHp.size() >= 5) {
                    this.dHr = 5;
                } else {
                    this.dHr = this.dHp.size();
                }
                if (post.tail_info != null) {
                    this.dHu = new com.baidu.tbadk.data.a();
                    this.dHu.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.dHv = new com.baidu.tbadk.data.d();
                    this.dHv.a(post.lbs_info);
                }
                this.Xg = post.storecount.intValue();
                this.dHs.a(post.present);
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.cMf = new SmallTailInfo();
                    this.cMf.id = post.signature.signature_id.intValue();
                    this.cMf.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.cMf.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.cMf.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.cMf.updateShowInfo();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private Context mContext;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mContext = null;
            this.mName = str;
            this.mId = str2;
            this.mContext = context;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.mContext != null) {
                textPaint.setColor(as.getColor(n.d.cp_link_tip_c));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String aS(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> FA;
        if (this.dHq == null || (FA = this.dHq.FA()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = FA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.FG().toString());
            } else if (next.getType() == 17) {
                String str = next.FK().avZ.avz;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(n.j.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(n.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(n.j.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int aFw() {
        return this.dHr;
    }

    public void mZ(int i) {
        this.dHr = i;
    }

    public ai aFx() {
        ArrayList<com.baidu.tbadk.widget.richText.c> FA;
        if (this.dHq != null && (FA = this.dHq.FA()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = FA.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ai aiVar = new ai();
                    aiVar.width = next.FF().getWidth();
                    aiVar.height = next.FF().getHeight();
                    aiVar.Xp = next.FF().FQ();
                    aiVar.abU = 17;
                    return aiVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> FA;
        if (this.dHq == null || (FA = this.dHq.FA()) == null) {
            return null;
        }
        ArrayList<ai> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = FA.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ai aiVar = new ai();
                aiVar.width = next.FF().getWidth();
                aiVar.height = next.FF().getHeight();
                aiVar.Xp = next.FF().FQ();
                aiVar.abU = 17;
                arrayList.add(aiVar);
            } else if (next.FK() != null) {
                ai aiVar2 = new ai();
                aiVar2.width = next.FK().avZ.avC;
                aiVar2.height = next.FK().avZ.avD;
                aiVar2.abV = next.FK();
                aiVar2.abU = 20;
                arrayList.add(aiVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dHr) {
                break;
            }
            arrayList.addAll(this.dHp.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ai aiVar3 = new ai();
            aiVar3.Xp = this.bimg_url;
            aiVar3.width = 105;
            aiVar3.width = 105;
            aiVar3.abU = 19;
            arrayList.add(aiVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ai aiVar4 = new ai();
        aiVar4.Xp = this.author.getPortrait();
        aiVar4.abU = 12;
        arrayList.add(aiVar4);
        if (this.dHp != null) {
            Iterator<r> it2 = this.dHp.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.dHi == 2) {
            return dHc;
        }
        if (this.dHi == 1) {
            return dHd;
        }
        if (this.dHi == 36) {
            return dHf;
        }
        if (this.dHx != null && this.dHx.dGJ) {
            int aET = this.dHx.aET();
            if (aET == 2) {
                return dHg;
            }
            if (aET == 1) {
                return dHh;
            }
            return dHe;
        }
        return dHb;
    }

    public boolean aFy() {
        return this.dHn;
    }

    public void ht(boolean z) {
        this.dHn = z;
    }

    public void setPostType(int i) {
        this.dHi = i;
    }

    public com.baidu.tbadk.core.data.r aFz() {
        return this.dHs;
    }

    public void a(com.baidu.tbadk.core.data.r rVar) {
        this.dHs = rVar;
    }

    public h aFA() {
        return this.dHx;
    }
}
