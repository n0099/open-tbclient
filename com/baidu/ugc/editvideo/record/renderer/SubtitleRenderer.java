package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import d.a.z.b.a.e;
import java.util.List;
/* loaded from: classes5.dex */
public class SubtitleRenderer extends MediaBaseRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] mProjectionMatrix;
    public List<MultiMediaData> mSubtitleDataList;

    public SubtitleRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProjectionMatrix = new float[16];
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(e eVar, int i2, float[] fArr) {
        List<MultiMediaData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, eVar, i2, fArr) == null) || eVar == null || (list = this.mSubtitleDataList) == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            MultiMediaData multiMediaData = this.mSubtitleDataList.get(i3);
            if (multiMediaData != null && !TextUtils.isEmpty(multiMediaData.subTitleText)) {
                float[] fArr2 = new float[16];
                Matrix.setIdentityM(fArr2, 0);
                GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
                Matrix.multiplyMM(fArr2, 0, this.mProjectionMatrix, 0, MultiMediaPreProcessor.calculateModelView(multiMediaData, gLViewPortLocation.width, gLViewPortLocation.height, this.mPreviewWidth, this.mPreviewHeight), 0);
                GLViewPortLocation gLViewPortLocation2 = this.mGLViewPortLocation;
                float f2 = this.mScaleX;
                int i4 = gLViewPortLocation2.width;
                float f3 = this.mScaleY;
                int i5 = gLViewPortLocation2.height;
                GLES20.glViewport((int) (gLViewPortLocation2.x + (((1.0f - f2) * i4) / 2.0f) + ((i4 * this.mTx) / 2.0f)), (int) (gLViewPortLocation2.y + (((1.0f - f3) * i5) / 2.0f) + ((i5 * this.mTy) / 2.0f)), (int) (i4 * f2), (int) (i5 * f3));
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(1, BankSignFactory.BEAN_ID_BIND_CARD);
                FullFrameRect fullFrameRect = multiMediaData.type == 0 ? this.mFullScreen2D : this.mFullScreenEXT;
                fullFrameRect.setVertexPoint(fArr2);
                fullFrameRect.drawFrame(multiMediaData.textureId, multiMediaData.mtx);
                Matrix.setIdentityM(fArr2, 0);
                fullFrameRect.setVertexPoint(fArr2);
                GLES20.glDisable(3042);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gLViewPortLocation) == null) {
            super.onGLLocation(gLViewPortLocation);
            Matrix.orthoM(this.mProjectionMatrix, 0, 0.0f, gLViewPortLocation.width, 0.0f, gLViewPortLocation.height, -1.0f, 1.0f);
        }
    }

    public void setSubtileDataList(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.mSubtitleDataList = list;
        }
    }
}
