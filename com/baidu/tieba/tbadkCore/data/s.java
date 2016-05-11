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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.at;
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
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class s implements v, ak {
    private ay QR;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private com.baidu.tbadk.widget.richText.o dgK;
    private SmallTailInfo drr;
    private String etb;
    private ArrayList<s> ete;
    private ArrayList<s> eth;
    private int eti;
    private com.baidu.tbadk.data.b etm;
    private com.baidu.tbadk.data.f etn;
    private i etp;
    private String etq;
    private String etr;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId esQ = BdUniqueId.gen();
    public static final BdUniqueId esR = BdUniqueId.gen();
    public static final BdUniqueId QU = BdUniqueId.gen();
    public static final BdUniqueId esS = BdUniqueId.gen();
    public static final BdUniqueId esT = BdUniqueId.gen();
    public static final BdUniqueId PV = BdUniqueId.gen();
    public static final BdUniqueId esU = BdUniqueId.gen();
    public static final BdUniqueId esV = BdUniqueId.gen();
    public static final BdUniqueId esW = BdUniqueId.gen();
    public static final BdUniqueId esX = BdUniqueId.gen();
    public static final BdUniqueId dfq = BdUniqueId.gen();
    public static final BdUniqueId esY = BdUniqueId.gen();
    private int esZ = 0;
    private boolean etf = false;
    private com.baidu.tbadk.widget.richText.a cCl = null;
    private boolean etl = false;
    private boolean eto = false;
    private String id = null;
    private String title = null;
    private int eta = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> czX = new ArrayList<>();
    private ArrayList<l> cAN = new ArrayList<>();
    private int etd = 0;
    private int etg = 0;
    private int QE = 0;
    private PraiseData praise = new PraiseData();
    private ae etj = new ae();
    private c etk = new c();
    private ArrayList<com.baidu.tbadk.data.b> QS = new ArrayList<>();

    public s() {
        this.ete = null;
        this.eth = null;
        this.ete = new ArrayList<>();
        this.eth = new ArrayList<>();
    }

    public c aTN() {
        return this.etk;
    }

    public ArrayList<s> aTO() {
        return this.ete;
    }

    public void aTP() {
        this.etd++;
    }

    public void aTQ() {
        this.etd--;
    }

    public void pn(int i) {
        this.etd = i;
    }

    public ArrayList<s> aTR() {
        return this.eth;
    }

    public boolean isGiftPost() {
        return this.eto;
    }

    public void setIsGiftPost(boolean z) {
        this.eto = z;
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

    public int aTS() {
        return this.eta;
    }

    public void po(int i) {
        this.eta = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.ay.x(j);
    }

    public String aTT() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public PraiseData getPraise() {
        return this.praise;
    }

    public void setPraise(PraiseData praiseData) {
        this.praise = praiseData;
    }

    public com.baidu.tbadk.widget.richText.a amw() {
        return this.cCl;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.cCl = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.b aTU() {
        return this.etm;
    }

    public SmallTailInfo aAC() {
        return this.drr;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.drr = smallTailInfo;
    }

    public com.baidu.tbadk.data.f aTV() {
        return this.etn;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        z zVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cA;
        if (tbPageContext != null && this.cCl != null && this.cCl.GC() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new t(this, it.next(), uniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m11getInst().getApp().getResources().getDimensionPixelSize(t.e.small_icon_width), TbadkCoreApplication.m11getInst().getApp().getResources().getDimensionPixelSize(t.e.small_icon_height));
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
            if (z && (cA = at.cA(t.f.icon_floorhost)) != null) {
                int width = (cA.getWidth() * dimensionPixelSize) / cA.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
                bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> GC = this.cCl.GC();
            if (GC != null && GC.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = GC.get(0);
                if (cVar2.GI() != null) {
                    cVar2.fb(sb.length());
                    cVar2.GI().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= GC.size()) {
                        zVar = null;
                        break;
                    } else if (GC.get(i4) == null || GC.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        z GJ = GC.get(i4).GJ();
                        GC.remove(i4);
                        zVar = GJ;
                        break;
                    }
                }
                if (zVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(zVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.fb(sb.length());
                cVar.append(spannableString);
                GC.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap iY;
        if (aVar == null || (iY = aVar.iY()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(iY);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m11getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36), TbadkCoreApplication.m11getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36));
        return bitmapDrawable;
    }

    public int aTW() {
        return this.etd;
    }

    public int aTX() {
        return this.etg;
    }

    public void aS(Context context) {
        int type;
        int i;
        int i2;
        if (this.czX != null) {
            int i3 = -1;
            int size = this.cAN.size();
            if (size > 0) {
                try {
                    i3 = this.cAN.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.czX.size()) {
                l lVar = this.czX.get(i4);
                if (l.ba(i5, lVar.getType())) {
                    this.cAN.get(size - 1).a(lVar.aR(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.cAN.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.a(lVar.aR(context));
                        this.cAN.add(lVar2);
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

    public void aT(Context context) {
        try {
            if (this.cCl != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cCl.toString());
                clipboardManager.getText();
                return;
            }
            if (this.cAN == null || this.cAN.size() == 0) {
                aS(context);
            }
            ArrayList<l> arrayList = this.cAN;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.aTB() != null) {
                            sb.append((CharSequence) next.aTB());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(t.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(t.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fk = TbFaceManager.CG().fk(next.getText());
                        if (fk != null) {
                            sb.append("[");
                            sb.append(fk);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.ay.isEmpty(next.aTA())) {
                        sb.append("[").append(next.aTA()).append("]");
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
                this.eta = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.ay.x(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.eto = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cCl = TbRichTextView.b(context, subPostList.content, z);
                if (this.cCl != null) {
                    this.cCl.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
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
                this.eta = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.ay.x(this.time);
                this.etb = post.time_ex;
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
                    this.etq = String.valueOf(this.author.getUserName()) + context.getResources().getString(t.j.whose_head_image);
                    this.etr = String.format(TbadkCoreApplication.m11getInst().getString(t.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.etl = post.is_ntitle.intValue() == 1;
                this.etd = post.sub_post_number.intValue();
                this.etg = post.add_post_number.intValue();
                this.etp = new i(post.tpoint_post);
                this.cCl = TbRichTextView.b(context, post.content, true);
                if (this.cCl != null) {
                    this.cCl.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.cCl.fa(this.eta);
                    if (this.author != null) {
                        this.cCl.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            s sVar = new s();
                            sVar.eto = subPostList.is_giftpost.intValue() == 1;
                            sVar.setUserMap(this.userMap);
                            sVar.a(subPostList, context);
                            this.ete.add(sVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            s sVar2 = new s();
                            sVar2.setUserMap(this.userMap);
                            sVar2.a(subPostList2, context);
                            this.eth.add(sVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.etk.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.eth.size() >= 5) {
                    this.eti = 5;
                } else {
                    this.eti = this.eth.size();
                }
                if (post.tail_info != null) {
                    this.etm = new com.baidu.tbadk.data.b();
                    this.etm.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.etn = new com.baidu.tbadk.data.f();
                    this.etn.a(post.lbs_info);
                }
                this.QE = post.storecount.intValue();
                this.etj.a(post.present);
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.drr = new SmallTailInfo();
                    this.drr.id = post.signature.signature_id.intValue();
                    this.drr.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.drr.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.drr.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.drr.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.QS.add(bVar);
                    }
                }
                if (post.high_together != null) {
                    this.QR = new ay();
                    this.QR.a(post.high_together);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> etx;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.etx = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.etx != null) {
                textPaint.setColor(at.getColor(t.d.cp_link_tip_c));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.etx != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.etx.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String aU(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GC;
        if (this.cCl == null || (GC = this.cCl.GC()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GC.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.GI().toString());
            } else if (next.getType() == 17) {
                String str = next.GM().aty.asZ;
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

    public int aTY() {
        return this.eti;
    }

    public void pp(int i) {
        this.eti = i;
    }

    public aj aTZ() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GC;
        if (this.cCl != null && (GC = this.cCl.GC()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = GC.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    aj ajVar = new aj();
                    ajVar.width = next.GH().getWidth();
                    ajVar.height = next.GH().getHeight();
                    ajVar.imgUrl = next.GH().GU();
                    ajVar.Xc = 17;
                    return ajVar;
                } else if (next.getType() == 1536) {
                    if (next.GQ() == null || TextUtils.isEmpty(next.GQ().url)) {
                        return null;
                    }
                    aj ajVar2 = new aj();
                    ajVar2.imgUrl = next.GQ().url;
                    ajVar2.Xc = 17;
                    return ajVar2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ak
    public ArrayList<aj> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GC;
        if (this.cCl == null || (GC = this.cCl.GC()) == null) {
            return null;
        }
        ArrayList<aj> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GC.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                aj ajVar = new aj();
                ajVar.width = next.GH().getWidth();
                ajVar.height = next.GH().getHeight();
                ajVar.imgUrl = next.GH().GU();
                ajVar.Xc = 17;
                arrayList.add(ajVar);
            } else if (next.GM() != null) {
                aj ajVar2 = new aj();
                ajVar2.width = next.GM().aty.atc;
                ajVar2.height = next.GM().aty.atd;
                ajVar2.Xd = next.GM();
                ajVar2.Xc = 20;
                arrayList.add(ajVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eti) {
                break;
            }
            arrayList.addAll(this.eth.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            aj ajVar3 = new aj();
            ajVar3.imgUrl = this.bimg_url;
            ajVar3.width = 105;
            ajVar3.width = 105;
            ajVar3.Xc = 19;
            arrayList.add(ajVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        aj ajVar4 = new aj();
        ajVar4.imgUrl = this.author.getPortrait();
        ajVar4.Xc = 12;
        arrayList.add(ajVar4);
        if (this.eth != null) {
            Iterator<s> it2 = this.eth.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.esZ == 2) {
            return esR;
        }
        if (this.esZ == 1) {
            return QU;
        }
        if (this.esZ == 36) {
            return esT;
        }
        if (this.esZ == 40) {
            return PV;
        }
        if (this.esZ == 41) {
            return esW;
        }
        if (this.etp != null && this.etp.esx) {
            int aTv = this.etp.aTv();
            if (aTv == 2) {
                return esU;
            }
            if (aTv == 1) {
                return esV;
            }
            return esS;
        } else if (this.QR != null && !TextUtils.isEmpty(this.QR.getActivityName())) {
            return esY;
        } else {
            return esQ;
        }
    }

    public boolean aUa() {
        return this.etf;
    }

    public void jz(boolean z) {
        this.etf = z;
    }

    public void setPostType(int i) {
        this.esZ = i;
    }

    public ae aUb() {
        return this.etj;
    }

    public void a(ae aeVar) {
        this.etj = aeVar;
    }

    public i aUc() {
        return this.etp;
    }

    public com.baidu.tbadk.widget.richText.o GL() {
        if (this.dgK != null) {
            return this.dgK;
        }
        if (this.cCl != null && y.r(this.cCl.GC()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.cCl.GC().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.dgK = next.GL();
                    return this.dgK;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> aUd() {
        return this.QS;
    }

    public String aUe() {
        return this.etq;
    }

    public String aUf() {
        return this.etr;
    }
}
