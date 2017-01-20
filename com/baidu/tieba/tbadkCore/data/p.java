package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.r;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class p implements v, ag {
    private SkinInfo TL;
    private String TP;
    private TbRichTextVoiceInfo aGY;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String efg;
    private SmallTailInfo esP;
    private ArrayList<p> fpZ;
    private com.baidu.tbadk.data.b fqf;
    private com.baidu.tbadk.data.g fqg;
    private h fqj;
    private com.baidu.tbadk.widget.richText.e fqk;
    private String fql;
    private String fqm;
    private TPointPost fqo;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fpL = BdUniqueId.gen();
    public static final BdUniqueId fpM = BdUniqueId.gen();
    public static final BdUniqueId TM = BdUniqueId.gen();
    public static final BdUniqueId fpN = BdUniqueId.gen();
    public static final BdUniqueId Sz = BdUniqueId.gen();
    public static final BdUniqueId fpO = BdUniqueId.gen();
    public static final BdUniqueId fpP = BdUniqueId.gen();
    public static final BdUniqueId fpQ = BdUniqueId.gen();
    public static final BdUniqueId fpR = BdUniqueId.gen();
    public static final BdUniqueId fpS = BdUniqueId.gen();
    public static final BdUniqueId efQ = BdUniqueId.gen();
    public static final BdUniqueId fpT = BdUniqueId.gen();
    public static final BdUniqueId fpU = BdUniqueId.gen();
    public static boolean fpV = false;
    private int fpW = 0;
    private boolean fqa = false;
    private ArrayList<p> fqb = null;
    private TbRichText dnz = null;
    private boolean fqe = false;
    private boolean fqh = false;
    private boolean fqi = false;
    public int Tn = 0;
    public boolean fqn = false;
    private String id = null;
    private String title = null;
    private int fpX = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dlm = new ArrayList<>();
    private ArrayList<k> dmc = new ArrayList<>();
    private int fpY = 0;
    private int Tx = 0;
    private PraiseData Tb = new PraiseData();
    private ap fqc = new ap();
    private c fqd = new c();
    private ArrayList<com.baidu.tbadk.data.b> TJ = new ArrayList<>();

    public p() {
        this.fpZ = null;
        this.fpZ = new ArrayList<>();
    }

    public ArrayList<p> bhJ() {
        return this.fqb;
    }

    public void s(p pVar) {
        if (pVar != null) {
            if (this.fqb == null) {
                this.fqb = new ArrayList<>();
                if (w.r(this.fpZ) > 2) {
                    this.fqb.addAll(w.a(this.fpZ, 0, 2));
                } else {
                    this.fqb.addAll(this.fpZ);
                }
            }
            this.fqb.add(pVar);
        }
    }

    public void t(p pVar) {
        if (pVar != null && this.fpZ != null) {
            this.fpZ.add(pVar);
            bhO();
        }
    }

    public void qE(String str) {
        if (this.fqb != null && !StringUtils.isNull(str)) {
            Iterator<p> it = this.fqb.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fqb.remove(next);
                    return;
                }
            }
        }
    }

    public void lh(boolean z) {
        this.fqa = z;
    }

    public boolean bhK() {
        return this.fqa;
    }

    public TPointPost bhL() {
        return this.fqo;
    }

    public c bhM() {
        return this.fqd;
    }

    public ArrayList<p> bhN() {
        return this.fpZ;
    }

    public void bhO() {
        this.fpY++;
    }

    public void bhP() {
        this.fpY--;
    }

    public void rU(int i) {
        this.fpY = i;
    }

    public boolean isGiftPost() {
        return this.fqh;
    }

    public void setIsGiftPost(boolean z) {
        this.fqh = z;
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

    public String aJM() {
        return this.efg;
    }

    public int bhQ() {
        return this.fpX;
    }

    public void rV(int i) {
        this.fpX = i;
    }

    public boolean bhR() {
        return this.fqi;
    }

    public void li(boolean z) {
        this.fqi = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.r(j);
    }

    public String bhS() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.Tb = praiseData;
    }

    public TbRichText awW() {
        return this.dnz;
    }

    public void f(TbRichText tbRichText) {
        this.dnz = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aPB() {
        return this.esP;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.esP = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bhT() {
        return this.fqg;
    }

    public SkinInfo rR() {
        return this.TL;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dnz != null && this.dnz.Hq() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " 楼主" : "";
            TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new q(this, it.next(), uniqueId), 0, 1);
                    eVar.d(0, 0, TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(r.f.ds32), TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(r.f.ds32));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.author.getSealPrefix());
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
            if (!StringUtils.isNull(this.author.getSealPrefix())) {
                Bitmap cP = com.baidu.tbadk.core.util.ap.cP(r.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cP);
                if (cP != null) {
                    bitmapDrawable.setBounds(0, 0, cP.getWidth(), cP.getHeight());
                }
                ak akVar = new ak(bitmapDrawable);
                akVar.setOffset(com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(akVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.f.ds28));
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_a));
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length() + this.author.getName_show().length() + 1, sb2.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(foregroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length(), sb2.length() + str3.length(), 17);
                    spannableString.setSpan(foregroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Hq = this.dnz.Hq();
            if (Hq != null && Hq.size() > 0) {
                TbRichTextData tbRichTextData2 = Hq.get(0);
                if (tbRichTextData2.Hw() != null) {
                    tbRichTextData2.fx(sb.length());
                    tbRichTextData2.Hw().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Hq.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Hq.get(i4) == null || Hq.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Hx = Hq.get(i4).Hx();
                        Hq.remove(i4);
                        tbRichTextVoiceInfo = Hx;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.fx(sb.length());
                tbRichTextData.append(spannableString);
                Hq.add(0, tbRichTextData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap jT;
        if (aVar == null || (jT = aVar.jT()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jT);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(r.f.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(r.f.ds36));
        return bitmapDrawable;
    }

    public int bhU() {
        return this.fpY;
    }

    public void bt(Context context) {
        int type;
        int i;
        int i2;
        if (this.dlm != null) {
            int i3 = -1;
            int size = this.dmc.size();
            if (size > 0) {
                try {
                    i3 = this.dmc.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dlm.size()) {
                k kVar = this.dlm.get(i4);
                if (k.bn(i5, kVar.getType())) {
                    this.dmc.get(size - 1).a(kVar.bs(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dmc.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.a(kVar.bs(context));
                        this.dmc.add(kVar2);
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

    public void bu(Context context) {
        try {
            if (this.dnz != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dnz.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dmc == null || this.dmc.size() == 0) {
                bt(context);
            }
            ArrayList<k> arrayList = this.dmc;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bhB() != null) {
                            sb.append((CharSequence) next.bhB());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(r.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(r.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fp = TbFaceManager.DR().fp(next.getText());
                        if (fp != null) {
                            sb.append("[");
                            sb.append(fp);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.bhA())) {
                        sb.append("[").append(next.bhA()).append("]");
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
                this.fpX = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = at.r(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fqh = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dnz = TbRichTextView.b(context, subPostList.content, z);
                if (this.dnz != null) {
                    this.dnz.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.fpX = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.r(this.time);
                this.efg = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fql = String.valueOf(this.author.getUserName()) + context.getResources().getString(r.l.somebodys_portrait);
                    this.fqm = String.format(TbadkCoreApplication.m9getInst().getString(r.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fqe = post.is_ntitle.intValue() == 1;
                this.fpY = post.sub_post_number.intValue();
                this.fqj = new h(post.tpoint_post);
                this.dnz = TbRichTextView.b(context, post.content, true);
                if (this.dnz != null) {
                    this.dnz.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dnz.fw(this.fpX);
                    if (this.author != null) {
                        this.dnz.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            p pVar = new p();
                            pVar.fqh = subPostList.is_giftpost.intValue() == 1;
                            pVar.setUserMap(this.userMap);
                            pVar.a(subPostList, context);
                            this.fpZ.add(pVar);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fqd.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fqf = new com.baidu.tbadk.data.b();
                    this.fqf.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fqg = new com.baidu.tbadk.data.g();
                    this.fqg.a(post.lbs_info);
                }
                this.Tx = post.storecount.intValue();
                this.fqc.a(post.present);
                this.Tb.setUserMap(this.userMap);
                this.Tb.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.esP = new SmallTailInfo();
                    this.esP.id = post.signature.signature_id.intValue();
                    this.esP.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.esP.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.esP.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.esP.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.TJ.add(bVar);
                    }
                }
                this.TL = post.skin_info;
                this.TP = post.lego_card;
                this.fqo = post.tpoint_post;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fqu;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fqu = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fqu != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fqu.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bv(Context context) {
        ArrayList<TbRichTextData> Hq;
        if (this.dnz == null || (Hq = this.dnz.Hq()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Hq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Hw().toString());
            } else if (next.getType() == 17) {
                String str = next.HA().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(r.l.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(r.l.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(r.l.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(r.l.msglist_graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bhV() {
        ArrayList<TbRichTextData> Hq;
        if (this.dnz != null && (Hq = this.dnz.Hq()) != null) {
            Iterator<TbRichTextData> it = Hq.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Hv().getWidth();
                    preLoadImageInfo.height = next.Hv().getHeight();
                    preLoadImageInfo.imgUrl = next.Hv().HJ();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.HE() == null || TextUtils.isEmpty(next.HE().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.HE().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bhW() {
        j bhq;
        PreLoadImageInfo bhV = bhV();
        if (bhV != null && !StringUtils.isNull(bhV.imgUrl)) {
            return bhV.imgUrl;
        }
        if (this.fqj != null && (bhq = this.fqj.bhq()) != null && !StringUtils.isNull(bhq.bhx())) {
            return bhq.bhx();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Hq;
        if (this.dnz == null || (Hq = this.dnz.Hq()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Hq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Hv().getWidth();
                preLoadImageInfo.height = next.Hv().getHeight();
                preLoadImageInfo.imgUrl = next.Hv().HJ();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.HA() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.HA().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.HA().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.HA();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.author == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.author.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.fpW == 52) {
            return fpU;
        }
        if (this.fpW == 2) {
            return fpM;
        }
        if (this.fpW == 1) {
            return TM;
        }
        if (this.fpW == 36) {
            return fpN;
        }
        if (this.fpW == 40 || this.fpW == 50) {
            return Sz;
        }
        if (this.fpW == 41) {
            return fpR;
        }
        if (fpV) {
            if (this.fqj != null && this.fqj.fpt) {
                int bhu = this.fqj.bhu();
                if (bhu == 2) {
                    return fpO;
                }
                if (bhu == 1) {
                    return fpP;
                }
                if (bhu == 3) {
                    return fpQ;
                }
                return fpL;
            } else if (this.fpW == 48) {
                return fpT;
            }
        }
        return fpL;
    }

    public void setPostType(int i) {
        this.fpW = i;
    }

    public ap bhX() {
        return this.fqc;
    }

    public void a(ap apVar) {
        this.fqc = apVar;
    }

    public h bhY() {
        return this.fqj;
    }

    public com.baidu.tbadk.widget.richText.e Hz() {
        if (this.fqk != null) {
            return this.fqk;
        }
        if (this.dnz != null && w.r(this.dnz.Hq()) > 0) {
            Iterator<TbRichTextData> it = this.dnz.Hq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fqk = next.Hz();
                    return this.fqk;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Hx() {
        if (this.aGY != null) {
            return this.aGY;
        }
        if (this.dnz != null && w.r(this.dnz.Hq()) > 0) {
            Iterator<TbRichTextData> it = this.dnz.Hq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aGY = next.Hx();
                    return this.aGY;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bhZ() {
        return this.TJ;
    }

    public String bia() {
        return this.fql;
    }

    public String bib() {
        return this.fqm;
    }

    public String sq() {
        return this.TP;
    }

    public void st() {
        if (this.Tn == 0) {
            this.Tn = 1;
        }
    }
}
