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
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
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
public class PostData implements com.baidu.adp.widget.ListView.m, ae {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private SkinInfo cOX;
    private OriginalThreadInfo cPD;
    private String cPa;
    private TbRichTextVoiceInfo dea;
    private SmallTailInfo iRn;
    private String ivR;
    private String iwL;
    private ArrayList<PostData> kbW;
    private boolean kcB;
    private boolean kcE;
    public an kcG;
    private com.baidu.tbadk.data.c kcd;
    private com.baidu.tbadk.data.f kce;
    private i kch;
    private bf kci;
    public boolean kck;
    private com.baidu.tbadk.widget.richText.i kcl;
    private String kcm;
    private String kcn;
    private TPointPost kco;
    public int kcr;
    public boolean kcu;
    public AlaLiveInfoCoreData kcx;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kbI = BdUniqueId.gen();
    public static final BdUniqueId kbJ = BdUniqueId.gen();
    public static final BdUniqueId cOY = BdUniqueId.gen();
    public static final BdUniqueId kbK = BdUniqueId.gen();
    public static final BdUniqueId cNl = BdUniqueId.gen();
    public static final BdUniqueId kbL = BdUniqueId.gen();
    public static final BdUniqueId kbM = BdUniqueId.gen();
    public static final BdUniqueId kbN = BdUniqueId.gen();
    public static final BdUniqueId kbO = BdUniqueId.gen();
    public static final BdUniqueId kbP = BdUniqueId.gen();
    public static boolean kbQ = false;
    private int kbR = 0;
    private boolean kbX = false;
    private ArrayList<PostData> kbY = null;
    private TbRichText kbZ = null;
    private boolean kcc = false;
    private boolean kcf = false;
    private boolean kcg = false;
    public boolean kcj = false;
    public int cOx = 0;
    private boolean kcp = false;
    public boolean gqt = false;
    public boolean kcq = false;
    public boolean kcs = false;
    public boolean kct = true;
    public boolean kcv = false;
    public boolean kcw = false;
    private boolean kcy = false;
    private int kcz = 0;
    private boolean kcA = true;
    public boolean kcC = false;
    public boolean kcD = false;
    public boolean kcF = false;
    private b kcH = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.kcG != null) {
                an aDS = PostData.this.kcG.aDS();
                aDS.delete("obj_locate");
                aDS.Z("obj_locate", 7);
                TiebaStatic.log(aDS);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kbS = 0;
    private long time = 0;
    private String date = null;
    private MetaData cNZ = new MetaData();
    private ArrayList<l> kbT = new ArrayList<>();
    private ArrayList<l> kbU = new ArrayList<>();
    private int kbV = 0;
    private int cOI = 0;
    private PraiseData cOl = new PraiseData();
    private ar kca = new ar();
    private c kcb = new c();
    private ArrayList<com.baidu.tbadk.data.c> cOU = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kbW = null;
        this.kcr = 0;
        this.kbW = new ArrayList<>();
        this.kcr = 0;
    }

    public void su(boolean z) {
        this.kcB = z;
    }

    public boolean cIl() {
        return this.kcB;
    }

    public ArrayList<PostData> cIm() {
        return this.kbY;
    }

    public void cIn() {
        this.kbY.clear();
        this.kbY = null;
        this.kbX = false;
    }

    public void u(PostData postData) {
        if (postData != null) {
            if (this.kbY == null) {
                this.kbY = new ArrayList<>();
                if (v.getCount(this.kbW) > 2) {
                    this.kbY.addAll(v.subList(this.kbW, 0, 2));
                } else {
                    this.kbY.addAll(this.kbW);
                }
            }
            this.kbY.add(postData);
        }
    }

    public void v(PostData postData) {
        if (postData != null && this.kbW != null) {
            this.kbW.add(postData);
            cIr();
        }
    }

    public void ID(String str) {
        if (this.kbY != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kbY.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kbY.remove(next);
                    return;
                }
            }
        }
    }

    public void sv(boolean z) {
        this.kcA = z;
    }

    public boolean cIo() {
        return this.kcA;
    }

    public void sw(boolean z) {
        this.kbX = z;
    }

    public boolean cIp() {
        return this.kbX;
    }

    public ArrayList<PostData> cIq() {
        return this.kbW;
    }

    public void cIr() {
        this.kbV++;
    }

    public void cIs() {
        this.kbV--;
    }

    public void Ck(int i) {
        this.kbV = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String chC() {
        return this.ivR;
    }

    public int cIt() {
        return this.kbS;
    }

    public void Cl(int i) {
        this.kbS = i;
    }

    public boolean cIu() {
        return this.kcg;
    }

    public void sx(boolean z) {
        this.kcg = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData azE() {
        return this.cNZ;
    }

    public void a(MetaData metaData) {
        this.cNZ = metaData;
    }

    public void a(PraiseData praiseData) {
        this.cOl = praiseData;
    }

    public TbRichText cIv() {
        return this.kbZ;
    }

    public void c(TbRichText tbRichText) {
        this.kbZ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo cpy() {
        return this.iRn;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.iRn = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cIw() {
        return this.kce;
    }

    public SkinInfo azZ() {
        return this.cOX;
    }

    public void sy(boolean z) {
        this.kcy = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kbZ != null && this.kbZ.aRf() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.cNZ != null && this.cNZ.getIs_bawu() == 1) {
                    if (this.kcB) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.cNZ.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.cNZ.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.cNZ.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.cNZ.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = azE().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.gs().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.gs().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.kbZ.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.cNZ.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.cNZ.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.cNZ == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.cNZ.getName_show() + str + "：");
                str2 = this.cNZ.getUserName();
                str3 = this.cNZ.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.cNZ.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.cNZ.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.kcH), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.cNZ != null && this.cNZ.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.cNZ != null && this.cNZ.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.cNZ != null) {
                        int i3 = 0;
                        if (this.cNZ.getName_show() != null) {
                            i3 = this.cNZ.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> aRf = this.kbZ.aRf();
            if (aRf != null && aRf.size() > 0) {
                TbRichTextData tbRichTextData2 = aRf.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.aRm() != null) {
                    if (this.kcy) {
                        int indexOf = tbRichTextData2.aRm().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.aRm().delete(0, indexOf + 1);
                        }
                        this.kcy = false;
                    }
                    tbRichTextData2.nc(sb.length());
                    tbRichTextData2.aRm().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aRf.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (aRf.get(i5) == null || aRf.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo aRn = aRf.get(i5).aRn();
                            aRf.remove(i5);
                            tbRichTextVoiceInfo = aRn;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.nc(sb.length());
                    tbRichTextData.j(spannableString);
                    aRf.add(0, tbRichTextData);
                }
            }
            this.kcC = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.fC(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.kE(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.tx(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cIx() {
        return this.kbV;
    }

    public void ft(Context context) {
        int type;
        int i;
        int i2;
        if (this.kbT != null) {
            int i3 = -1;
            int size = this.kbU.size();
            if (size > 0) {
                try {
                    i3 = this.kbU.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kbT.size()) {
                l lVar = this.kbT.get(i4);
                if (l.cI(i5, lVar.getType())) {
                    this.kbU.get(size - 1).b(lVar.fs(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kbU.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fs(context));
                        this.kbU.add(lVar2);
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

    public void fu(Context context) {
        try {
            if (this.kbZ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kbZ.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kbU == null || this.kbU.size() == 0) {
                ft(context);
            }
            ArrayList<l> arrayList = this.kbU;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cIe() != null) {
                            sb.append((CharSequence) next.cIe());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String uH = TbFaceManager.aMY().uH(next.getText());
                        if (uH != null) {
                            sb.append("[");
                            sb.append(uH);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cId())) {
                        sb.append("[").append(next.cId()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
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
                this.kbS = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.kcf = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cNZ = metaData;
                }
                if (this.cNZ.getUserId() == null || this.cNZ.getUserId().length() <= 0 || this.cNZ.getUserId().equals("0")) {
                    this.cNZ = metaData2;
                }
                this.kbZ = TbRichTextView.a(context, subPostList.content, z);
                if (this.kbZ != null) {
                    this.kbZ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.kbS = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.ivR = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cNZ = metaData;
                }
                this.gqt = post.need_log.intValue() == 1;
                this.kcq = post.img_num_abtest.intValue() == 1;
                this.kci = new bf();
                this.kci.parserProtobuf(post.from_forum);
                if (this.cNZ.getUserId() == null || this.cNZ.getUserId().length() <= 0 || this.cNZ.getUserId().equals("0")) {
                    this.cNZ.parserProtobuf(post.author);
                }
                if (this.cNZ != null && context != null) {
                    this.kcm = this.cNZ.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.kcn = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.cNZ.getLevel_id()));
                }
                this.kcc = post.is_ntitle.intValue() == 1;
                this.kbV = post.sub_post_number.intValue();
                this.kch = new i(post.tpoint_post);
                this.kbZ = TbRichTextView.a(context, post.content, true);
                if (this.kbZ != null) {
                    this.kbZ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kbZ.nb(this.kbS);
                    if (this.cNZ != null) {
                        this.kbZ.setAuthorId(this.cNZ.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.kcf = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.su(this.kcB);
                            postData.a(subPostList, context);
                            this.kbW.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kcb.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kcd = new com.baidu.tbadk.data.c();
                    this.kcd.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.kce = new com.baidu.tbadk.data.f();
                    this.kce.a(post.lbs_info);
                }
                this.cOI = post.storecount.intValue();
                this.kca.a(post.present);
                this.cOl.setUserMap(this.userMap);
                this.cOl.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.iRn = new SmallTailInfo();
                    this.iRn.id = post.signature.signature_id.intValue();
                    this.iRn.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.iRn.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.iRn.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.iRn.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.cOU.add(cVar);
                    }
                }
                this.cOX = post.skin_info;
                this.cPa = post.lego_card;
                this.kco = post.tpoint_post;
                if (post.agree != null) {
                    this.kcp = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.kcp = false;
                }
                this.kcw = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cPD = new OriginalThreadInfo();
                    this.cPD.a(post.origin_thread_info);
                } else {
                    this.cPD = null;
                }
                this.kcz = post.is_fold.intValue();
                this.iwL = post.fold_tip;
                this.kcD = post.is_top_agree_post.intValue() == 1;
                this.kcE = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> kcN;
        private b kcO;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.kcN = new SoftReference<>(context);
            this.kcO = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.kcN != null) {
                if (this.kcO != null) {
                    this.kcO.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kcN.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fv(Context context) {
        ArrayList<TbRichTextData> aRf;
        if (this.kbZ == null || (aRf = this.kbZ.aRf()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = aRf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.aRm().toString());
            } else if (next.getType() == 17) {
                String str = next.aRq().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String cIy() {
        ArrayList<TbRichTextData> aRf;
        String str;
        if (this.kbZ == null || (aRf = this.kbZ.aRf()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = aRf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.aRm().toString());
                } else if (next.getType() == 17) {
                    if (next.aRq() != null && next.aRq().mGifInfo != null && (str = next.aRq().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cIz() {
        ArrayList<TbRichTextData> aRf;
        if (this.kbZ != null && (aRf = this.kbZ.aRf()) != null) {
            Iterator<TbRichTextData> it = aRf.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.aRl().getWidth();
                    preLoadImageInfo.height = next.aRl().getHeight();
                    preLoadImageInfo.imgUrl = next.aRl().aRz();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.aRr().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.aRr().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.aRr().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cIA() {
        k cHW;
        PreLoadImageInfo cIz = cIz();
        if (cIz != null && !StringUtils.isNull(cIz.imgUrl)) {
            return cIz.imgUrl;
        }
        if (this.kch != null && (cHW = this.kch.cHW()) != null && !StringUtils.isNull(cHW.cIb())) {
            return cHW.cIb();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> aRf;
        if (this.kbZ == null || (aRf = this.kbZ.aRf()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = aRf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.aRl().getWidth();
                preLoadImageInfo.height = next.aRl().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aRl().aRE()) {
                    preLoadImageInfo.imgUrl = next.aRl().aRA();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.aRl().aRz();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.aRq() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.aRq().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.aRq().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.aRq();
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
        if (this.cNZ == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.cNZ.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kbR == 52) {
            return kbN;
        }
        if (this.kbR == 1) {
            return cOY;
        }
        if (this.kbR == 36) {
            return kbK;
        }
        if (this.kbR == 40 || this.kbR == 50) {
            return cNl;
        }
        if (this.kbR == 41) {
            return kbL;
        }
        if (this.kbR == 53) {
            return kbO;
        }
        if (cIt() == 1) {
            return kbI;
        }
        return kbJ;
    }

    public void setPostType(int i) {
        this.kbR = i;
    }

    public ar cIB() {
        return this.kca;
    }

    public void a(ar arVar) {
        this.kca = arVar;
    }

    public i cIC() {
        return this.kch;
    }

    public com.baidu.tbadk.widget.richText.i aRp() {
        if (this.kcl != null) {
            return this.kcl;
        }
        if (this.kbZ != null && v.getCount(this.kbZ.aRf()) > 0) {
            Iterator<TbRichTextData> it = this.kbZ.aRf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.kcl = next.aRp();
                    return this.kcl;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo aRn() {
        if (this.dea != null) {
            return this.dea;
        }
        if (this.kbZ != null && v.getCount(this.kbZ.aRf()) > 0) {
            Iterator<TbRichTextData> it = this.kbZ.aRf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.dea = next.aRn();
                    return this.dea;
                }
            }
        }
        return null;
    }

    public String cID() {
        return this.kcm;
    }

    public String aAM() {
        return this.cPa;
    }

    public void aAO() {
        if (this.cOx == 0) {
            this.cOx = 1;
        }
    }

    public long aBa() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aBt() {
        return this.agreeData;
    }

    public OriginalThreadInfo cIE() {
        return this.cPD;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.cPD = originalThreadInfo;
    }

    public int cIF() {
        return this.kcz;
    }

    public String chS() {
        return this.iwL;
    }

    public boolean cIG() {
        return this.kcE;
    }
}
