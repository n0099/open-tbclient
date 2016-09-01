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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class q implements v, al {
    private bj Uq;
    private SkinInfo Ut;
    private String Ux;
    @Deprecated
    private String authorId;
    private String bimg_url;
    public DealInfoData dealInfoData;
    private String ejQ;
    private SmallTailInfo ewM;
    private ArrayList<q> fsO;
    private ArrayList<q> fsR;
    private int fsS;
    private com.baidu.tbadk.data.b fsW;
    private com.baidu.tbadk.data.g fsX;
    private i fsZ;
    private com.baidu.tbadk.widget.richText.o fta;
    private String ftb;
    private String ftc;
    private TPointPost fte;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fsz = BdUniqueId.gen();
    public static final BdUniqueId fsA = BdUniqueId.gen();
    public static final BdUniqueId Uu = BdUniqueId.gen();
    public static final BdUniqueId fsB = BdUniqueId.gen();
    public static final BdUniqueId fsC = BdUniqueId.gen();
    public static final BdUniqueId Tl = BdUniqueId.gen();
    public static final BdUniqueId fsD = BdUniqueId.gen();
    public static final BdUniqueId fsE = BdUniqueId.gen();
    public static final BdUniqueId fsF = BdUniqueId.gen();
    public static final BdUniqueId fsG = BdUniqueId.gen();
    public static final BdUniqueId fsH = BdUniqueId.gen();
    public static final BdUniqueId ekx = BdUniqueId.gen();
    public static final BdUniqueId fsI = BdUniqueId.gen();
    public static final BdUniqueId fsJ = BdUniqueId.gen();
    public static boolean fsK = false;
    private int fsL = 0;
    private boolean fsP = false;
    private com.baidu.tbadk.widget.richText.a dwo = null;
    private boolean fsV = false;
    private boolean fsY = false;
    public boolean ftd = false;
    private String id = null;
    private String title = null;
    private int fsM = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> dua = new ArrayList<>();
    private ArrayList<l> duQ = new ArrayList<>();
    private int fsN = 0;
    private int fsQ = 0;
    private int Ue = 0;
    private PraiseData TK = new PraiseData();
    private com.baidu.tbadk.core.data.al fsT = new com.baidu.tbadk.core.data.al();
    private c fsU = new c();
    private ArrayList<com.baidu.tbadk.data.b> Ur = new ArrayList<>();

    public q() {
        this.fsO = null;
        this.fsR = null;
        this.fsO = new ArrayList<>();
        this.fsR = new ArrayList<>();
    }

    public TPointPost biW() {
        return this.fte;
    }

    public c biX() {
        return this.fsU;
    }

    public ArrayList<q> biY() {
        return this.fsO;
    }

    public void biZ() {
        this.fsN++;
    }

    public void bja() {
        this.fsN--;
    }

    public void rx(int i) {
        this.fsN = i;
    }

    public ArrayList<q> bjb() {
        return this.fsR;
    }

    public boolean isGiftPost() {
        return this.fsY;
    }

    public void setIsGiftPost(boolean z) {
        this.fsY = z;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aLD() {
        return this.ejQ;
    }

    public int bjc() {
        return this.fsM;
    }

    public void ry(int i) {
        this.fsM = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ba.t(j);
    }

    public String bjd() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public PraiseData rt() {
        return this.TK;
    }

    public void a(PraiseData praiseData) {
        this.TK = praiseData;
    }

    public com.baidu.tbadk.widget.richText.a aAk() {
        return this.dwo;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.dwo = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.b bje() {
        return this.fsW;
    }

    public SmallTailInfo aQY() {
        return this.ewM;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.ewM = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bjf() {
        return this.fsX;
    }

    public SkinInfo rU() {
        return this.Ut;
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        z zVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cN;
        if (tbPageContext != null && this.dwo != null && this.dwo.Ia() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new r(this, it.next(), uniqueId), 0, 1);
                    eVar.d(0, 0, TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(t.e.ds32), TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(t.e.ds32));
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
            a aVar = new a(tbPageContext.getPageActivity(), str, str2);
            if (z && (cN = av.cN(t.f.icon_floorhost)) != null) {
                int width = (cN.getWidth() * dimensionPixelSize) / cN.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> Ia = this.dwo.Ia();
            if (Ia != null && Ia.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = Ia.get(0);
                if (cVar2.Ig() != null) {
                    cVar2.fu(sb.length());
                    cVar2.Ig().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Ia.size()) {
                        zVar = null;
                        break;
                    } else if (Ia.get(i4) == null || Ia.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        z Ih = Ia.get(i4).Ih();
                        Ia.remove(i4);
                        zVar = Ih;
                        break;
                    }
                }
                if (zVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(zVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.fu(sb.length());
                cVar.append(spannableString);
                Ia.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap jV;
        if (aVar == null || (jV = aVar.jV()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jV);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36));
        return bitmapDrawable;
    }

    public int bjg() {
        return this.fsN;
    }

    public int bjh() {
        return this.fsQ;
    }

    public void bh(Context context) {
        int type;
        int i;
        int i2;
        if (this.dua != null) {
            int i3 = -1;
            int size = this.duQ.size();
            if (size > 0) {
                try {
                    i3 = this.duQ.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dua.size()) {
                l lVar = this.dua.get(i4);
                if (l.bq(i5, lVar.getType())) {
                    this.duQ.get(size - 1).a(lVar.bg(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.duQ.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.a(lVar.bg(context));
                        this.duQ.add(lVar2);
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

    public void bi(Context context) {
        try {
            if (this.dwo != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dwo.toString());
                clipboardManager.getText();
                return;
            }
            if (this.duQ == null || this.duQ.size() == 0) {
                bh(context);
            }
            ArrayList<l> arrayList = this.duQ;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.biP() != null) {
                            sb.append((CharSequence) next.biP());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(t.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(t.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fr = TbFaceManager.Ej().fr(next.getText());
                        if (fr != null) {
                            sb.append("[");
                            sb.append(fr);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ba.isEmpty(next.biO())) {
                        sb.append("[").append(next.biO()).append("]");
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
                this.fsM = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ba.t(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fsY = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dwo = TbRichTextView.b(context, subPostList.content, z);
                if (this.dwo != null) {
                    this.dwo.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
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
                this.fsM = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ba.t(this.time);
                this.ejQ = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.ftb = String.valueOf(this.author.getUserName()) + context.getResources().getString(t.j.whose_head_image);
                    this.ftc = String.format(TbadkCoreApplication.m9getInst().getString(t.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fsV = post.is_ntitle.intValue() == 1;
                this.fsN = post.sub_post_number.intValue();
                this.fsQ = post.add_post_number.intValue();
                this.fsZ = new i(post.tpoint_post);
                this.dwo = TbRichTextView.b(context, post.content, true);
                if (this.dwo != null) {
                    this.dwo.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.dwo.ft(this.fsM);
                    if (this.author != null) {
                        this.dwo.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            q qVar = new q();
                            qVar.fsY = subPostList.is_giftpost.intValue() == 1;
                            qVar.setUserMap(this.userMap);
                            qVar.a(subPostList, context);
                            this.fsO.add(qVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            q qVar2 = new q();
                            qVar2.setUserMap(this.userMap);
                            qVar2.a(subPostList2, context);
                            this.fsR.add(qVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fsU.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.fsR.size() >= 5) {
                    this.fsS = 5;
                } else {
                    this.fsS = this.fsR.size();
                }
                if (post.tail_info != null) {
                    this.fsW = new com.baidu.tbadk.data.b();
                    this.fsW.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fsX = new com.baidu.tbadk.data.g();
                    this.fsX.a(post.lbs_info);
                }
                this.Ue = post.storecount.intValue();
                this.fsT.a(post.present);
                this.TK.setUserMap(this.userMap);
                this.TK.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.ewM = new SmallTailInfo();
                    this.ewM.id = post.signature.signature_id.intValue();
                    this.ewM.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.ewM.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.ewM.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.ewM.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.Ur.add(bVar);
                    }
                }
                if (post.high_together != null) {
                    this.Uq = new bj();
                    this.Uq.a(post.high_together);
                }
                this.Ut = post.skin_info;
                if (post.pb_deal_info != null) {
                    this.dealInfoData = new DealInfoData();
                    this.dealInfoData.parserProtobuf(post.pb_deal_info);
                }
                this.Ux = post.lego_card;
                this.fte = post.tpoint_post;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> ftk;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.ftk = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(av.getColor(t.d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.ftk != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.ftk.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bj(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ia;
        if (this.dwo == null || (Ia = this.dwo.Ia()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Ia.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Ig().toString());
            } else if (next.getType() == 17) {
                String str = next.Ik().ayk.axL;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(t.j.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(t.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(t.j.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(t.j.msglist_graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int bji() {
        return this.fsS;
    }

    public void rz(int i) {
        this.fsS = i;
    }

    public ak bjj() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ia;
        if (this.dwo != null && (Ia = this.dwo.Ia()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = Ia.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ak akVar = new ak();
                    akVar.width = next.If().getWidth();
                    akVar.height = next.If().getHeight();
                    akVar.imgUrl = next.If().Iu();
                    akVar.aaR = 17;
                    return akVar;
                } else if (next.getType() == 1536) {
                    if (next.Io() == null || TextUtils.isEmpty(next.Io().url)) {
                        return null;
                    }
                    ak akVar2 = new ak();
                    akVar2.imgUrl = next.Io().url;
                    akVar2.aaR = 17;
                    return akVar2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<ak> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ia;
        if (this.dwo == null || (Ia = this.dwo.Ia()) == null) {
            return null;
        }
        ArrayList<ak> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Ia.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ak akVar = new ak();
                akVar.width = next.If().getWidth();
                akVar.height = next.If().getHeight();
                akVar.imgUrl = next.If().Iu();
                akVar.aaR = 17;
                arrayList.add(akVar);
            } else if (next.Ik() != null) {
                ak akVar2 = new ak();
                akVar2.width = next.Ik().ayk.axO;
                akVar2.height = next.Ik().ayk.axP;
                akVar2.aaS = next.Ik();
                akVar2.aaR = 20;
                arrayList.add(akVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fsS) {
                break;
            }
            arrayList.addAll(this.fsR.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ak akVar3 = new ak();
            akVar3.imgUrl = this.bimg_url;
            akVar3.width = 105;
            akVar3.width = 105;
            akVar3.aaR = 19;
            arrayList.add(akVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ak akVar4 = new ak();
        akVar4.imgUrl = this.author.getPortrait();
        akVar4.aaR = 12;
        arrayList.add(akVar4);
        if (this.fsR != null) {
            Iterator<q> it2 = this.fsR.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fsL == 2) {
            return fsA;
        }
        if (this.fsL == 1) {
            return Uu;
        }
        if (this.fsL == 36) {
            return fsC;
        }
        if (this.fsL == 40) {
            return Tl;
        }
        if (this.fsL == 41) {
            return fsG;
        }
        if (fsK) {
            if (this.fsZ != null && this.fsZ.fsh) {
                int biI = this.fsZ.biI();
                if (biI == 2) {
                    return fsD;
                }
                if (biI == 1) {
                    return fsE;
                }
                if (biI == 3) {
                    return fsF;
                }
                return fsB;
            } else if (this.fsL == 48) {
                return fsJ;
            }
        }
        if (this.Uq != null && !TextUtils.isEmpty(this.Uq.getActivityName())) {
            return fsI;
        }
        return fsz;
    }

    public boolean bjk() {
        return this.fsP;
    }

    public void kK(boolean z) {
        this.fsP = z;
    }

    public void setPostType(int i) {
        this.fsL = i;
    }

    public com.baidu.tbadk.core.data.al bjl() {
        return this.fsT;
    }

    public void a(com.baidu.tbadk.core.data.al alVar) {
        this.fsT = alVar;
    }

    public i bjm() {
        return this.fsZ;
    }

    public com.baidu.tbadk.widget.richText.o Ij() {
        if (this.fta != null) {
            return this.fta;
        }
        if (this.dwo != null && y.s(this.dwo.Ia()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dwo.Ia().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fta = next.Ij();
                    return this.fta;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bjn() {
        return this.Ur;
    }

    public String bjo() {
        return this.ftb;
    }

    public String bjp() {
        return this.ftc;
    }

    public String sv() {
        return this.Ux;
    }
}
