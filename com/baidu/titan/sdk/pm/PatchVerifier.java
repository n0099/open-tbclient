package com.baidu.titan.sdk.pm;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.internal.util.EncodeUtils;
import com.baidu.titan.sdk.verifier.SignatureVerifier;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PatchVerifier {
    public static final boolean DEBUG = false;
    public static final String TAG = "PatchVerifier";
    public static final int VERIFY_OK = 0;
    public String mCurId;
    public JSONObject mLogJson;
    public File mPatchFile;
    public SignatureVerifier mSigVerifier;

    public PatchVerifier(Context context, File file, String str, JSONObject jSONObject) {
        this.mPatchFile = file;
        this.mCurId = str;
        this.mLogJson = jSONObject;
        this.mSigVerifier = new SignatureVerifier(context, file);
    }

    private boolean verifyApkId(PatchMetaInfo patchMetaInfo) {
        String str = patchMetaInfo.targetId;
        if (str != null && TextUtils.equals(str, this.mCurId)) {
            return true;
        }
        return false;
    }

    public int verify() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = this.mLogJson;
        if (jSONObject2 != null) {
            try {
                jSONObject2.put("patchInfo", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                jSONObject.put("pathHash", EncodeUtils.bytesToHex(EncodeUtils.sha256(this.mPatchFile)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        int verifySignature = this.mSigVerifier.verifySignature();
        if (verifySignature != 0) {
            return verifySignature;
        }
        PatchMetaInfo createFromPatch = PatchMetaInfo.createFromPatch(this.mPatchFile);
        if (createFromPatch == null) {
            return -1;
        }
        if (this.mLogJson != null) {
            try {
                jSONObject.put("metaInfo", createFromPatch.toJson());
                jSONObject.put("curApkId", this.mCurId);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (!verifyApkId(createFromPatch)) {
            return -4;
        }
        return 0;
    }
}
