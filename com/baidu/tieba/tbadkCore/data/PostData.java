package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements q, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eHi;
    private OriginalThreadInfo eLH;
    private SkinInfo eLb;
    private String eLe;
    private Item eMy;
    private TbRichTextVoiceInfo fdM;
    private String lBp;
    private SmallTailInfo lYe;
    public int locate;
    private String nlR;
    private ArrayList<PostData> nlV;
    private boolean nmA;
    public ar nmE;
    public List<PbContent> nmH;
    private com.baidu.tbadk.data.c nmc;
    private com.baidu.tbadk.data.g nmd;
    private i nmg;
    private bu nmh;
    public boolean nmj;
    private com.baidu.tbadk.widget.richText.i nmk;
    private String nml;
    private String nmm;
    private TPointPost nmn;
    public int nmq;
    public boolean nmt;
    public AlaLiveInfoCoreData nmw;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nlI = BdUniqueId.gen();
    public static final BdUniqueId nlJ = BdUniqueId.gen();
    public static final BdUniqueId eLc = BdUniqueId.gen();
    public static final BdUniqueId eJk = BdUniqueId.gen();
    public static final BdUniqueId eJq = BdUniqueId.gen();
    public static final BdUniqueId nlK = BdUniqueId.gen();
    public static final BdUniqueId nlL = BdUniqueId.gen();
    public static final BdUniqueId nlM = BdUniqueId.gen();
    public static final BdUniqueId nlN = BdUniqueId.gen();
    public static final BdUniqueId nlO = BdUniqueId.gen();
    public static boolean nlP = false;
    private int nlQ = 0;
    private boolean nlW = false;
    private ArrayList<PostData> nlX = null;
    private TbRichText nlY = null;
    private boolean nmb = false;
    private boolean nme = false;
    private boolean nmf = false;
    public boolean nmi = false;
    public int eKB = 0;
    private boolean nmo = false;
    public boolean jbR = false;
    public boolean nmp = false;
    public boolean nmr = false;
    public boolean nms = true;
    public boolean nmu = false;
    public boolean nmv = false;
    private boolean nmx = false;
    private int nmy = 0;
    private boolean nmz = true;
    public boolean nmB = false;
    public boolean nmC = false;
    public boolean nmD = false;
    public boolean nmF = false;
    public boolean nmG = false;
    int nmI = com.baidu.tbadk.a.d.bkC();
    private b nmJ = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nmE != null) {
                ar btS = PostData.this.nmE.btS();
                btS.delete("obj_locate");
                btS.al("obj_locate", 7);
                TiebaStatic.log(btS);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eKe = new MetaData();
    private ArrayList<l> nlS = new ArrayList<>();
    private ArrayList<l> nlT = new ArrayList<>();
    private int nlU = 0;
    private int eKM = 0;
    private PraiseData eKp = new PraiseData();
    private az nlZ = new az();
    private c nma = new c();
    private ArrayList<com.baidu.tbadk.data.c> eKY = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nlV = null;
        this.nmq = 0;
        this.nlV = new ArrayList<>();
        this.nmq = 0;
    }

    public void xY(boolean z) {
        this.nmA = z;
    }

    public boolean dOZ() {
        return this.nmA;
    }

    public ArrayList<PostData> dPa() {
        return this.nlX;
    }

    public void dPb() {
        this.nlX.clear();
        this.nlX = null;
        this.nlW = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nlX == null) {
                this.nlX = new ArrayList<>();
                if (y.getCount(this.nlV) > this.nmI) {
                    this.nlX.addAll(y.subList(this.nlV, 0, this.nmI));
                } else {
                    this.nlX.addAll(this.nlV);
                }
            }
            this.nlX.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nlV != null) {
            this.nlV.add(postData);
            dPf();
        }
    }

    public void TG(String str) {
        if (this.nlX != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nlX.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nlX.remove(next);
                    return;
                }
            }
        }
    }

    public void xZ(boolean z) {
        this.nmz = z;
    }

    public boolean dPc() {
        return this.nmz;
    }

    public void ya(boolean z) {
        this.nlW = z;
    }

    public boolean dPd() {
        return this.nlW;
    }

    public ArrayList<PostData> dPe() {
        return this.nlV;
    }

    public void dPf() {
        this.nlU++;
    }

    public void dPg() {
        this.nlU--;
    }

    public void KU(int i) {
        this.nlU = i;
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

    public int dPh() {
        return this.floor_num;
    }

    public void KV(int i) {
        this.floor_num = i;
    }

    public boolean dPi() {
        return this.nmf;
    }

    public void yb(boolean z) {
        this.nmf = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.getFormatTime(j);
    }

    public MetaData boP() {
        return this.eKe;
    }

    public void a(MetaData metaData) {
        this.eKe = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eKp = praiseData;
    }

    public TbRichText dPj() {
        return this.nlY;
    }

    public void c(TbRichText tbRichText) {
        this.nlY = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo duZ() {
        return this.lYe;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lYe = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dPk() {
        return this.nmd;
    }

    public SkinInfo bpl() {
        return this.eLb;
    }

    public void yc(boolean z) {
        this.nmx = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nlY != null && this.nlY.bIC() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.eKe != null && this.eKe.getIs_bawu() == 1) {
                    if (this.nmA) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eKe.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eKe.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eKe.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eKe.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = boP().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mS().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.mS().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.i(aVar2));
                                            PostData.this.nlY.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.i(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eKe.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eKe.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eKe == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.eKe.getName_show() + str + "：");
                str2 = this.eKe.getUserName();
                str3 = this.eKe.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eKe.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eKe.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.nmJ), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eKe != null && this.eKe.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b f = f(z, this.eKe != null && this.eKe.getIs_bawu() == 1, str);
                if (f != null) {
                    if (this.eKe != null) {
                        int i3 = 0;
                        if (this.eKe.getName_show() != null) {
                            i3 = this.eKe.getName_show().length();
                        }
                        spannableString.setSpan(f, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(f, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bIC = this.nlY.bIC();
            if (bIC != null && bIC.size() > 0) {
                TbRichTextData tbRichTextData2 = bIC.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bIJ() != null) {
                    if (this.nmx) {
                        int indexOf = tbRichTextData2.bIJ().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bIJ().delete(0, indexOf + 1);
                        }
                        this.nmx = false;
                    }
                    tbRichTextData2.tA(sb.length());
                    tbRichTextData2.bIJ().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bIC.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bIC.get(i5) == null || bIC.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bIK = bIC.get(i5).bIK();
                            bIC.remove(i5);
                            tbRichTextVoiceInfo = bIK;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.tA(sb.length());
                    tbRichTextData.q(spannableString);
                    bIC.add(0, tbRichTextData);
                }
            }
            this.nmB = true;
        }
    }

    private com.baidu.tbadk.core.view.b f(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0302, dimens4, dimens5);
                bVar.qC(dimens2);
                bVar.jB(false);
                bVar.Cv(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.qC(dimens2);
                bVar2.jB(true);
                bVar2.Cv(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
    }

    protected Drawable i(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dPl() {
        return this.nlU;
    }

    public void gC(Context context) {
        int type;
        int i;
        int i2;
        if (this.nlS != null) {
            int i3 = -1;
            int size = this.nlT.size();
            if (size > 0) {
                try {
                    i3 = this.nlT.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.nlS.size()) {
                l lVar = this.nlS.get(i4);
                if (l.dz(i5, lVar.getType())) {
                    this.nlT.get(size - 1).b(lVar.gB(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nlT.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gB(context));
                        this.nlT.add(lVar2);
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

    public void gD(Context context) {
        try {
            if (this.nlY != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nlY.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nlT == null || this.nlT.size() == 0) {
                gC(context);
            }
            ArrayList<l> arrayList = this.nlT;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dOS() != null) {
                            sb.append((CharSequence) next.dOS());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String DM = TbFaceManager.bDU().DM(next.getText());
                        if (DM != null) {
                            sb.append("[");
                            sb.append(DM);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.dOR())) {
                        sb.append("[").append(next.dOR()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (Exception e) {
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
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = au.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.nme = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eKe = metaData;
                }
                if (this.eKe.getUserId() == null || this.eKe.getUserId().length() <= 0 || this.eKe.getUserId().equals("0")) {
                    this.eKe = metaData2;
                }
                this.nlY = TbRichTextView.a(context, subPostList.content, z);
                if (this.nlY != null) {
                    this.nlY.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = au.getFormatTime(this.time);
                this.nlR = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eKe = metaData;
                }
                this.jbR = post.need_log.intValue() == 1;
                this.nmp = post.img_num_abtest.intValue() == 1;
                this.nmh = new bu();
                this.nmh.parserProtobuf(post.from_forum);
                if (this.eKe.getUserId() == null || this.eKe.getUserId().length() <= 0 || this.eKe.getUserId().equals("0")) {
                    this.eKe.parserProtobuf(post.author);
                }
                if (this.eKe != null && context != null) {
                    this.nml = this.eKe.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nmm = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eKe.getLevel_id()));
                }
                this.nmb = post.is_ntitle.intValue() == 1;
                this.nlU = post.sub_post_number.intValue();
                this.nmg = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nmH = post.content;
                this.nmF = post.is_wonderful_post.intValue() == 1;
                this.nmC = post.is_top_agree_post.intValue() == 1;
                this.eHi = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eMy = post.item;
                }
                this.nlY = TbRichTextView.a(context, list, true);
                if (this.nlY != null) {
                    this.nlY.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nlY.tz(this.floor_num);
                    if (this.eKe != null) {
                        this.nlY.setAuthorId(this.eKe.getUserId());
                    }
                    int count = y.getCount(this.eHi);
                    if (this.floor_num == 1 && count != 0 && this.eHi != null) {
                        ArrayList<TbRichTextData> bIC = this.nlY.bIC();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bIC, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bIC, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.eHi, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.r(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eHi.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eHi.get(size);
                                if (headItem2 != null) {
                                    a(bIC, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eMy != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eMy));
                        y.add(this.nlY.bIC(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nme = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.xY(this.nmA);
                            postData.a(subPostList, context);
                            this.nlV.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nma.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nmc = new com.baidu.tbadk.data.c();
                    this.nmc.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nmd = new com.baidu.tbadk.data.g();
                    this.nmd.a(post.lbs_info);
                }
                this.eKM = post.storecount.intValue();
                this.nlZ.a(post.present);
                this.eKp.setUserMap(this.userMap);
                this.eKp.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lYe = new SmallTailInfo();
                    this.lYe.id = post.signature.signature_id.intValue();
                    this.lYe.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lYe.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lYe.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lYe.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eKY.add(cVar);
                    }
                }
                this.eLb = post.skin_info;
                this.eLe = post.lego_card;
                this.nmn = post.tpoint_post;
                if (post.agree != null) {
                    this.nmo = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nmo = false;
                }
                this.nmv = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eLH = new OriginalThreadInfo();
                    this.eLH.a(post.origin_thread_info);
                } else {
                    this.eLH = null;
                }
                this.nmy = post.is_fold.intValue();
                this.lBp = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.q(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> nmP;
        private b nmQ;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nmP = new SoftReference<>(context);
            this.nmQ = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nmP != null && this.nmP.get() != null) {
                if (this.nmQ != null) {
                    this.nmQ.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nmP.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gE(Context context) {
        ArrayList<TbRichTextData> bIC;
        if (this.nlY == null || (bIC = this.nlY.bIC()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bIC.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bIJ().toString());
            } else if (next.getType() == 17) {
                String str = next.bIN().mGifInfo.mSharpText;
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

    public String dPm() {
        ArrayList<TbRichTextData> bIC;
        String str;
        if (this.nlY == null || (bIC = this.nlY.bIC()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bIC.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bIJ().toString());
                } else if (next.getType() == 17) {
                    if (next.bIN() != null && next.bIN().mGifInfo != null && (str = next.bIN().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dPn() {
        ArrayList<TbRichTextData> bIC;
        if (this.nlY != null && (bIC = this.nlY.bIC()) != null) {
            Iterator<TbRichTextData> it = bIC.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bII().getWidth();
                    preLoadImageInfo.height = next.bII().getHeight();
                    preLoadImageInfo.imgUrl = next.bII().bIX();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bIO().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bIO().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bIO().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dPo() {
        k dOP;
        PreLoadImageInfo dPn = dPn();
        if (dPn != null && !StringUtils.isNull(dPn.imgUrl)) {
            return dPn.imgUrl;
        }
        if (this.nmg != null && (dOP = this.nmg.dOP()) != null && !StringUtils.isNull(dOP.dOQ())) {
            return dOP.dOQ();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bIC;
        if (this.nlY == null || (bIC = this.nlY.bIC()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bIC.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bII().getWidth();
                preLoadImageInfo.height = next.bII().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bII().bJc()) {
                    preLoadImageInfo.imgUrl = next.bII().bIY();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bII().bIX();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bIN() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bIN().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bIN().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bIN();
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
        if (this.eKe == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eKe.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.nlQ == 52) {
            return nlM;
        }
        if (this.nlQ == 1) {
            return eLc;
        }
        if (this.nlQ == 36) {
            return eJk;
        }
        if (this.nlQ == 40 || this.nlQ == 50) {
            return eJq;
        }
        if (this.nlQ == 41) {
            return nlK;
        }
        if (this.nlQ == 53) {
            return nlN;
        }
        if (dPh() == 1) {
            return nlI;
        }
        return nlJ;
    }

    public void setPostType(int i) {
        this.nlQ = i;
    }

    public az dPp() {
        return this.nlZ;
    }

    public void a(az azVar) {
        this.nlZ = azVar;
    }

    public i dPq() {
        return this.nmg;
    }

    public com.baidu.tbadk.widget.richText.i bIM() {
        if (this.nmk != null) {
            return this.nmk;
        }
        if (this.nlY != null && y.getCount(this.nlY.bIC()) > 0) {
            Iterator<TbRichTextData> it = this.nlY.bIC().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nmk = next.bIM();
                    return this.nmk;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bIK() {
        if (this.fdM != null) {
            return this.fdM;
        }
        if (this.nlY != null && y.getCount(this.nlY.bIC()) > 0) {
            Iterator<TbRichTextData> it = this.nlY.bIC().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fdM = next.bIK();
                    return this.fdM;
                }
            }
        }
        return null;
    }

    public String dPr() {
        return this.nml;
    }

    public String bqb() {
        return this.eLe;
    }

    public void bqd() {
        if (this.eKB == 0) {
            this.eKB = 1;
        }
    }

    public long bqq() {
        return this.agreeData.disAgreeNum;
    }

    public int bqs() {
        return this.agreeData.agreeType;
    }

    public AgreeData bqI() {
        return this.agreeData;
    }

    public OriginalThreadInfo dPs() {
        return this.eLH;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eLH = originalThreadInfo;
    }

    public int dPt() {
        return this.nmy;
    }

    public String dnf() {
        return this.lBp;
    }

    public Item bqV() {
        return this.eMy;
    }

    public List<HeadItem> bqW() {
        return this.eHi;
    }
}
