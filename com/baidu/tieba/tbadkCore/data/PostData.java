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
    private String cTB;
    private SkinInfo cTy;
    private OriginalThreadInfo cUe;
    private TbRichTextVoiceInfo diS;
    private String iDU;
    private SmallTailInfo iYa;
    private com.baidu.tbadk.data.c kiD;
    private com.baidu.tbadk.data.f kiE;
    private i kiH;
    private bf kiI;
    public boolean kiK;
    private com.baidu.tbadk.widget.richText.i kiL;
    private String kiM;
    private String kiN;
    private TPointPost kiO;
    public int kiR;
    public boolean kiU;
    public AlaLiveInfoCoreData kiX;
    private String kis;
    private ArrayList<PostData> kiw;
    private boolean kjb;
    private boolean kje;
    public an kjg;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId kih = BdUniqueId.gen();
    public static final BdUniqueId kii = BdUniqueId.gen();
    public static final BdUniqueId cTz = BdUniqueId.gen();
    public static final BdUniqueId kij = BdUniqueId.gen();
    public static final BdUniqueId cRN = BdUniqueId.gen();
    public static final BdUniqueId kik = BdUniqueId.gen();
    public static final BdUniqueId kil = BdUniqueId.gen();
    public static final BdUniqueId kim = BdUniqueId.gen();
    public static final BdUniqueId kin = BdUniqueId.gen();
    public static final BdUniqueId kio = BdUniqueId.gen();
    public static boolean kip = false;
    private int kiq = 0;
    private boolean kix = false;
    private ArrayList<PostData> kiy = null;
    private TbRichText kiz = null;
    private boolean kiC = false;
    private boolean kiF = false;
    private boolean kiG = false;
    public boolean kiJ = false;
    public int cSY = 0;
    private boolean kiP = false;
    public boolean gwy = false;
    public boolean kiQ = false;
    public boolean kiS = false;
    public boolean kiT = true;
    public boolean kiV = false;
    public boolean kiW = false;
    private boolean kiY = false;
    private int kiZ = 0;
    private boolean kja = true;
    public boolean kjc = false;
    public boolean kjd = false;
    public boolean kjf = false;
    private b kjh = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.kjg != null) {
                an aGC = PostData.this.kjg.aGC();
                aGC.delete("obj_locate");
                aGC.X("obj_locate", 7);
                TiebaStatic.log(aGC);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int kir = 0;
    private long time = 0;
    private String date = null;
    private MetaData cSB = new MetaData();
    private ArrayList<l> kit = new ArrayList<>();
    private ArrayList<l> kiu = new ArrayList<>();
    private int kiv = 0;
    private int cTj = 0;
    private PraiseData cSM = new PraiseData();
    private ar kiA = new ar();
    private c kiB = new c();
    private ArrayList<com.baidu.tbadk.data.c> cTv = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.kiw = null;
        this.kiR = 0;
        this.kiw = new ArrayList<>();
        this.kiR = 0;
    }

    public void sQ(boolean z) {
        this.kjb = z;
    }

    public boolean cLn() {
        return this.kjb;
    }

    public ArrayList<PostData> cLo() {
        return this.kiy;
    }

    public void cLp() {
        this.kiy.clear();
        this.kiy = null;
        this.kix = false;
    }

    public void t(PostData postData) {
        if (postData != null) {
            if (this.kiy == null) {
                this.kiy = new ArrayList<>();
                if (v.getCount(this.kiw) > 2) {
                    this.kiy.addAll(v.subList(this.kiw, 0, 2));
                } else {
                    this.kiy.addAll(this.kiw);
                }
            }
            this.kiy.add(postData);
        }
    }

    public void u(PostData postData) {
        if (postData != null && this.kiw != null) {
            this.kiw.add(postData);
            cLt();
        }
    }

    public void Jb(String str) {
        if (this.kiy != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.kiy.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.kiy.remove(next);
                    return;
                }
            }
        }
    }

    public void sR(boolean z) {
        this.kja = z;
    }

    public boolean cLq() {
        return this.kja;
    }

    public void sS(boolean z) {
        this.kix = z;
    }

    public boolean cLr() {
        return this.kix;
    }

    public ArrayList<PostData> cLs() {
        return this.kiw;
    }

    public void cLt() {
        this.kiv++;
    }

    public void cLu() {
        this.kiv--;
    }

    public void CD(int i) {
        this.kiv = i;
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

    public int cLv() {
        return this.kir;
    }

    public void CE(int i) {
        this.kir = i;
    }

    public boolean cLw() {
        return this.kiG;
    }

    public void sT(boolean z) {
        this.kiG = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aCr() {
        return this.cSB;
    }

    public void a(MetaData metaData) {
        this.cSB = metaData;
    }

    public void a(PraiseData praiseData) {
        this.cSM = praiseData;
    }

    public TbRichText cLx() {
        return this.kiz;
    }

    public void c(TbRichText tbRichText) {
        this.kiz = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo csv() {
        return this.iYa;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.iYa = smallTailInfo;
    }

    public com.baidu.tbadk.data.f cLy() {
        return this.kiE;
    }

    public SkinInfo aCM() {
        return this.cTy;
    }

    public void sU(boolean z) {
        this.kiY = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.kiz != null && this.kiz.aTX() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.cSB != null && this.cSB.getIs_bawu() == 1) {
                    if (this.kjb) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.cSB.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.cSB.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.cSB.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.cSB.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aCr().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.gr().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.gr().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.kiz.isChanged = true;
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
            if (!StringUtils.isNull(this.cSB.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.cSB.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.cSB == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.cSB.getName_show() + str + "：");
                str2 = this.cSB.getUserName();
                str3 = this.cSB.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.cSB.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.cSB.getSealPrefix().length() + 1;
                spannableString.setSpan(jVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.kjh), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.cSB != null && this.cSB.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.cSB != null && this.cSB.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.cSB != null) {
                        int i3 = 0;
                        if (this.cSB.getName_show() != null) {
                            i3 = this.cSB.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> aTX = this.kiz.aTX();
            if (aTX != null && aTX.size() > 0) {
                TbRichTextData tbRichTextData2 = aTX.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.aUe() != null) {
                    if (this.kiY) {
                        int indexOf = tbRichTextData2.aUe().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.aUe().delete(0, indexOf + 1);
                        }
                        this.kiY = false;
                    }
                    tbRichTextData2.nv(sb.length());
                    tbRichTextData2.aUe().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= aTX.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (aTX.get(i5) == null || aTX.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo aUf = aTX.get(i5).aUf();
                            aTX.remove(i5);
                            tbRichTextVoiceInfo = aUf;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.nv(sb.length());
                    tbRichTextData.j(spannableString);
                    aTX.add(0, tbRichTextData);
                }
            }
            this.kjc = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.fP(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.kV(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.tR(str);
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

    public int cLz() {
        return this.kiv;
    }

    public void ft(Context context) {
        int type;
        int i;
        int i2;
        if (this.kit != null) {
            int i3 = -1;
            int size = this.kiu.size();
            if (size > 0) {
                try {
                    i3 = this.kiu.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.kit.size()) {
                l lVar = this.kit.get(i4);
                if (l.cL(i5, lVar.getType())) {
                    this.kiu.get(size - 1).b(lVar.fs(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.kiu.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fs(context));
                        this.kiu.add(lVar2);
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
            if (this.kiz != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.kiz.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.kiu == null || this.kiu.size() == 0) {
                ft(context);
            }
            ArrayList<l> arrayList = this.kiu;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cLg() != null) {
                            sb.append((CharSequence) next.cLg());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String vd = TbFaceManager.aPU().vd(next.getText());
                        if (vd != null) {
                            sb.append("[");
                            sb.append(vd);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cLf())) {
                        sb.append("[").append(next.cLf()).append("]");
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
                this.kir = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.kiF = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSB = metaData;
                }
                if (this.cSB.getUserId() == null || this.cSB.getUserId().length() <= 0 || this.cSB.getUserId().equals("0")) {
                    this.cSB = metaData2;
                }
                this.kiz = TbRichTextView.a(context, subPostList.content, z);
                if (this.kiz != null) {
                    this.kiz.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
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
                this.kir = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.kis = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSB = metaData;
                }
                this.gwy = post.need_log.intValue() == 1;
                this.kiQ = post.img_num_abtest.intValue() == 1;
                this.kiI = new bf();
                this.kiI.parserProtobuf(post.from_forum);
                if (this.cSB.getUserId() == null || this.cSB.getUserId().length() <= 0 || this.cSB.getUserId().equals("0")) {
                    this.cSB.parserProtobuf(post.author);
                }
                if (this.cSB != null && context != null) {
                    this.kiM = this.cSB.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.kiN = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.cSB.getLevel_id()));
                }
                this.kiC = post.is_ntitle.intValue() == 1;
                this.kiv = post.sub_post_number.intValue();
                this.kiH = new i(post.tpoint_post);
                this.kiz = TbRichTextView.a(context, post.content, true);
                if (this.kiz != null) {
                    this.kiz.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.kiz.nu(this.kir);
                    if (this.cSB != null) {
                        this.kiz.setAuthorId(this.cSB.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.kiF = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.sQ(this.kjb);
                            postData.a(subPostList, context);
                            this.kiw.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.kiB.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.kiD = new com.baidu.tbadk.data.c();
                    this.kiD.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.kiE = new com.baidu.tbadk.data.f();
                    this.kiE.a(post.lbs_info);
                }
                this.cTj = post.storecount.intValue();
                this.kiA.a(post.present);
                this.cSM.setUserMap(this.userMap);
                this.cSM.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.iYa = new SmallTailInfo();
                    this.iYa.id = post.signature.signature_id.intValue();
                    this.iYa.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.iYa.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.iYa.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.iYa.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.cTv.add(cVar);
                    }
                }
                this.cTy = post.skin_info;
                this.cTB = post.lego_card;
                this.kiO = post.tpoint_post;
                if (post.agree != null) {
                    this.kiP = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.kiP = false;
                }
                this.kiW = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cUe = new OriginalThreadInfo();
                    this.cUe.a(post.origin_thread_info);
                } else {
                    this.cUe = null;
                }
                this.kiZ = post.is_fold.intValue();
                this.iDU = post.fold_tip;
                this.kjd = post.is_top_agree_post.intValue() == 1;
                this.kje = post.show_squared.intValue() == 1;
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
        private SoftReference<Context> kjn;
        private b kjo;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.kjn = new SoftReference<>(context);
            this.kjo = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.kjn != null && this.kjn.get() != null) {
                if (this.kjo != null) {
                    this.kjo.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.kjn.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fv(Context context) {
        ArrayList<TbRichTextData> aTX;
        if (this.kiz == null || (aTX = this.kiz.aTX()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = aTX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.aUe().toString());
            } else if (next.getType() == 17) {
                String str = next.aUi().mGifInfo.mSharpText;
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

    public String cLA() {
        ArrayList<TbRichTextData> aTX;
        String str;
        if (this.kiz == null || (aTX = this.kiz.aTX()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = aTX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.aUe().toString());
                } else if (next.getType() == 17) {
                    if (next.aUi() != null && next.aUi().mGifInfo != null && (str = next.aUi().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cLB() {
        ArrayList<TbRichTextData> aTX;
        if (this.kiz != null && (aTX = this.kiz.aTX()) != null) {
            Iterator<TbRichTextData> it = aTX.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.aUd().getWidth();
                    preLoadImageInfo.height = next.aUd().getHeight();
                    preLoadImageInfo.imgUrl = next.aUd().aUq();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.aUj().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.aUj().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.aUj().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cLC() {
        k cLd;
        PreLoadImageInfo cLB = cLB();
        if (cLB != null && !StringUtils.isNull(cLB.imgUrl)) {
            return cLB.imgUrl;
        }
        if (this.kiH != null && (cLd = this.kiH.cLd()) != null && !StringUtils.isNull(cLd.cLe())) {
            return cLd.cLe();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> aTX;
        if (this.kiz == null || (aTX = this.kiz.aTX()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = aTX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.aUd().getWidth();
                preLoadImageInfo.height = next.aUd().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aUd().aUv()) {
                    preLoadImageInfo.imgUrl = next.aUd().aUr();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.aUd().aUq();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.aUi() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.aUi().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.aUi().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.aUi();
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
        if (this.cSB == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.cSB.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.kiq == 52) {
            return kim;
        }
        if (this.kiq == 1) {
            return cTz;
        }
        if (this.kiq == 36) {
            return kij;
        }
        if (this.kiq == 40 || this.kiq == 50) {
            return cRN;
        }
        if (this.kiq == 41) {
            return kik;
        }
        if (this.kiq == 53) {
            return kin;
        }
        if (cLv() == 1) {
            return kih;
        }
        return kii;
    }

    public void setPostType(int i) {
        this.kiq = i;
    }

    public ar cLD() {
        return this.kiA;
    }

    public void a(ar arVar) {
        this.kiA = arVar;
    }

    public i cLE() {
        return this.kiH;
    }

    public com.baidu.tbadk.widget.richText.i aUh() {
        if (this.kiL != null) {
            return this.kiL;
        }
        if (this.kiz != null && v.getCount(this.kiz.aTX()) > 0) {
            Iterator<TbRichTextData> it = this.kiz.aTX().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.kiL = next.aUh();
                    return this.kiL;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo aUf() {
        if (this.diS != null) {
            return this.diS;
        }
        if (this.kiz != null && v.getCount(this.kiz.aTX()) > 0) {
            Iterator<TbRichTextData> it = this.kiz.aTX().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.diS = next.aUf();
                    return this.diS;
                }
            }
        }
        return null;
    }

    public String cLF() {
        return this.kiM;
    }

    public String aDy() {
        return this.cTB;
    }

    public void aDA() {
        if (this.cSY == 0) {
            this.cSY = 1;
        }
    }

    public long aDM() {
        return this.agreeData.disAgreeNum;
    }

    public AgreeData aEe() {
        return this.agreeData;
    }

    public OriginalThreadInfo cLG() {
        return this.cUe;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.cUe = originalThreadInfo;
    }

    public int cLH() {
        return this.kiZ;
    }

    public String ckX() {
        return this.iDU;
    }

    public boolean cLI() {
        return this.kje;
    }
}
