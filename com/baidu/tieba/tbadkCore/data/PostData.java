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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.al;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.w;
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
public class PostData implements v, ah {
    private SkinInfo Zn;
    private String Zq;
    private TbRichTextVoiceInfo aMM;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String efI;
    private SmallTailInfo eui;
    private ArrayList<PostData> fwd;
    private com.baidu.tbadk.data.b fwj;
    private com.baidu.tbadk.data.g fwk;
    private h fwn;
    private com.baidu.tbadk.widget.richText.e fwo;
    private String fwp;
    private String fwq;
    private TPointPost fws;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId fvP = BdUniqueId.gen();
    public static final BdUniqueId fvQ = BdUniqueId.gen();
    public static final BdUniqueId Zo = BdUniqueId.gen();
    public static final BdUniqueId fvR = BdUniqueId.gen();
    public static final BdUniqueId Yc = BdUniqueId.gen();
    public static final BdUniqueId fvS = BdUniqueId.gen();
    public static final BdUniqueId fvT = BdUniqueId.gen();
    public static final BdUniqueId fvU = BdUniqueId.gen();
    public static final BdUniqueId fvV = BdUniqueId.gen();
    public static final BdUniqueId fvW = BdUniqueId.gen();
    public static final BdUniqueId egt = BdUniqueId.gen();
    public static final BdUniqueId fvX = BdUniqueId.gen();
    public static final BdUniqueId fvY = BdUniqueId.gen();
    public static boolean fvZ = false;
    private int fwa = 0;
    private boolean fwe = false;
    private ArrayList<PostData> fwf = null;
    private TbRichText dos = null;
    private boolean fwi = false;
    private boolean fwl = false;
    private boolean fwm = false;
    public int YP = 0;
    public boolean fwr = false;
    private boolean fwt = false;
    private long fwu = 0;
    private boolean fwv = false;
    private String id = null;
    private String title = null;
    private int fwb = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<k> dme = new ArrayList<>();
    private ArrayList<k> dmU = new ArrayList<>();
    private int fwc = 0;
    private int YZ = 0;
    private PraiseData YD = new PraiseData();
    private aq fwg = new aq();
    private c fwh = new c();
    private ArrayList<com.baidu.tbadk.data.b> Zl = new ArrayList<>();

    public PostData() {
        this.fwd = null;
        this.fwd = new ArrayList<>();
    }

    public ArrayList<PostData> bih() {
        return this.fwf;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.fwf == null) {
                this.fwf = new ArrayList<>();
                if (x.p(this.fwd) > 2) {
                    this.fwf.addAll(x.a(this.fwd, 0, 2));
                } else {
                    this.fwf.addAll(this.fwd);
                }
            }
            this.fwf.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.fwd != null) {
            this.fwd.add(postData);
            bim();
        }
    }

    public void qd(String str) {
        if (this.fwf != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.fwf.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.fwf.remove(next);
                    return;
                }
            }
        }
    }

    public void li(boolean z) {
        this.fwe = z;
    }

    public boolean bii() {
        return this.fwe;
    }

    public TPointPost bij() {
        return this.fws;
    }

    public c bik() {
        return this.fwh;
    }

    public ArrayList<PostData> bil() {
        return this.fwd;
    }

    public void bim() {
        this.fwc++;
    }

    public void bin() {
        this.fwc--;
    }

    public void rR(int i) {
        this.fwc = i;
    }

    public boolean isGiftPost() {
        return this.fwl;
    }

    public void setIsGiftPost(boolean z) {
        this.fwl = z;
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

    public String aJk() {
        return this.efI;
    }

    public int bio() {
        return this.fwb;
    }

    public void rS(int i) {
        this.fwb = i;
    }

    public boolean bip() {
        return this.fwm;
    }

    public void lj(boolean z) {
        this.fwm = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.q(j);
    }

    public String biq() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public void a(PraiseData praiseData) {
        this.YD = praiseData;
    }

    public TbRichText awl() {
        return this.dos;
    }

    public void f(TbRichText tbRichText) {
        this.dos = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aPb() {
        return this.eui;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.eui = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bir() {
        return this.fwk;
    }

    public SkinInfo sJ() {
        return this.Zn;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.dos != null && this.dos.Io() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " 楼主" : "";
            TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new p(this, it.next(), uniqueId), 0, 1);
                    eVar.d(0, 0, TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(w.f.ds32), TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(w.f.ds32));
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
                Bitmap cO = com.baidu.tbadk.core.util.aq.cO(w.g.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                al alVar = new al(bitmapDrawable);
                alVar.setOffset(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds2));
                int size = arrayList.size() + this.author.getSealPrefix().length() + 1;
                spannableString.setSpan(alVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(w.e.cp_link_tip_a);
                if (this.author != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length() + this.author.getName_show().length() + 1, sb2.length() + this.author.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb2.length(), sb2.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Io = this.dos.Io();
            if (Io != null && Io.size() > 0) {
                TbRichTextData tbRichTextData2 = Io.get(0);
                if (tbRichTextData2.Iv() != null) {
                    tbRichTextData2.ft(sb.length());
                    tbRichTextData2.Iv().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Io.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Io.get(i4) == null || Io.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Iw = Io.get(i4).Iw();
                        Io.remove(i4);
                        tbRichTextVoiceInfo = Iw;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.ft(sb.length());
                tbRichTextData.append(spannableString);
                Io.add(0, tbRichTextData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap kR;
        if (aVar == null || (kR = aVar.kR()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kR);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(w.f.ds36));
        return bitmapDrawable;
    }

    public int bis() {
        return this.fwc;
    }

    public void bL(Context context) {
        int type;
        int i;
        int i2;
        if (this.dme != null) {
            int i3 = -1;
            int size = this.dmU.size();
            if (size > 0) {
                try {
                    i3 = this.dmU.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dme.size()) {
                k kVar = this.dme.get(i4);
                if (k.bp(i5, kVar.getType())) {
                    this.dmU.get(size - 1).a(kVar.bK(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.dmU.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.a(kVar.bK(context));
                        this.dmU.add(kVar2);
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

    public void bM(Context context) {
        try {
            if (this.dos != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dos.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dmU == null || this.dmU.size() == 0) {
                bL(context);
            }
            ArrayList<k> arrayList = this.dmU;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bhZ() != null) {
                            sb.append((CharSequence) next.bhZ());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(w.l.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(w.l.voice_str));
                    } else if (next.getType() == 2) {
                        String fk = TbFaceManager.EI().fk(next.getText());
                        if (fk != null) {
                            sb.append("[");
                            sb.append(fk);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.bhY())) {
                        sb.append("[").append(next.bhY()).append("]");
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
                this.fwb = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = au.q(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.fwl = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dos = TbRichTextView.b(context, subPostList.content, z);
                if (this.dos != null) {
                    this.dos.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.fwb = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = au.q(this.time);
                this.efI = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.fwp = String.valueOf(this.author.getUserName()) + context.getResources().getString(w.l.somebodys_portrait);
                    this.fwq = String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.fwi = post.is_ntitle.intValue() == 1;
                this.fwc = post.sub_post_number.intValue();
                this.fwn = new h(post.tpoint_post);
                this.dos = TbRichTextView.b(context, post.content, true);
                if (this.dos != null) {
                    this.dos.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.dos.fs(this.fwb);
                    if (this.author != null) {
                        this.dos.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.fwl = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.fwd.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.fwh.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.fwj = new com.baidu.tbadk.data.b();
                    this.fwj.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.fwk = new com.baidu.tbadk.data.g();
                    this.fwk.a(post.lbs_info);
                }
                this.YZ = post.storecount.intValue();
                this.fwg.a(post.present);
                this.YD.setUserMap(this.userMap);
                this.YD.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.eui = new SmallTailInfo();
                    this.eui.id = post.signature.signature_id.intValue();
                    this.eui.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.eui.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.eui.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.eui.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.Zl.add(bVar);
                    }
                }
                this.Zn = post.skin_info;
                this.Zq = post.lego_card;
                this.fws = post.tpoint_post;
                if (post.agree != null) {
                    this.fwt = true;
                    this.fwv = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.fwu = post.agree.agree_num.longValue();
                        return;
                    } else {
                        this.fwu = 0L;
                        return;
                    }
                }
                this.fwt = false;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int esu;

        public CustomForegroundColorSpan(int i) {
            super(com.baidu.tbadk.core.util.aq.getColor(i));
            this.esu = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(com.baidu.tbadk.core.util.aq.getColor(this.esu));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> fwB;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.fwB = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.fwB != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.fwB.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String bN(Context context) {
        ArrayList<TbRichTextData> Io;
        if (this.dos == null || (Io = this.dos.Io()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Io.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Iv().toString());
            } else if (next.getType() == 17) {
                String str = next.Iz().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(w.l.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(w.l.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(w.l.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(w.l.graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bit() {
        ArrayList<TbRichTextData> Io;
        if (this.dos != null && (Io = this.dos.Io()) != null) {
            Iterator<TbRichTextData> it = Io.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Iu().getWidth();
                    preLoadImageInfo.height = next.Iu().getHeight();
                    preLoadImageInfo.imgUrl = next.Iu().II();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 1536) {
                    if (next.ID() == null || TextUtils.isEmpty(next.ID().url)) {
                        return null;
                    }
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.imgUrl = next.ID().url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String biu() {
        j bhO;
        PreLoadImageInfo bit = bit();
        if (bit != null && !StringUtils.isNull(bit.imgUrl)) {
            return bit.imgUrl;
        }
        if (this.fwn != null && (bhO = this.fwn.bhO()) != null && !StringUtils.isNull(bhO.bhV())) {
            return bhO.bhV();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Io;
        if (this.dos == null || (Io = this.dos.Io()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Io.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Iu().getWidth();
                preLoadImageInfo.height = next.Iu().getHeight();
                preLoadImageInfo.imgUrl = next.Iu().II();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.Iz() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Iz().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Iz().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Iz();
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
        if (this.fwa == 52) {
            return fvY;
        }
        if (this.fwa == 2) {
            return fvQ;
        }
        if (this.fwa == 1) {
            return Zo;
        }
        if (this.fwa == 36) {
            return fvR;
        }
        if (this.fwa == 40 || this.fwa == 50) {
            return Yc;
        }
        if (this.fwa == 41) {
            return fvV;
        }
        if (fvZ) {
            if (this.fwn != null && this.fwn.fvx) {
                int bhS = this.fwn.bhS();
                if (bhS == 2) {
                    return fvS;
                }
                if (bhS == 1) {
                    return fvT;
                }
                if (bhS == 3) {
                    return fvU;
                }
                return fvP;
            } else if (this.fwa == 48) {
                return fvX;
            }
        }
        return fvP;
    }

    public void setPostType(int i) {
        this.fwa = i;
    }

    public aq biv() {
        return this.fwg;
    }

    public void a(aq aqVar) {
        this.fwg = aqVar;
    }

    public h biw() {
        return this.fwn;
    }

    public com.baidu.tbadk.widget.richText.e Iy() {
        if (this.fwo != null) {
            return this.fwo;
        }
        if (this.dos != null && x.p(this.dos.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dos.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.fwo = next.Iy();
                    return this.fwo;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Iw() {
        if (this.aMM != null) {
            return this.aMM;
        }
        if (this.dos != null && x.p(this.dos.Io()) > 0) {
            Iterator<TbRichTextData> it = this.dos.Io().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aMM = next.Iw();
                    return this.aMM;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bix() {
        return this.Zl;
    }

    public String biy() {
        return this.fwp;
    }

    public String biz() {
        return this.fwq;
    }

    public String tj() {
        return this.Zq;
    }

    public void tm() {
        if (this.YP == 0) {
            this.YP = 1;
        }
    }

    public boolean biA() {
        return this.fwt;
    }

    public long biB() {
        return this.fwu;
    }

    public void cB(long j) {
        this.fwu = j;
    }

    public boolean biC() {
        return this.fwv;
    }

    public void lk(boolean z) {
        this.fwv = z;
    }
}
